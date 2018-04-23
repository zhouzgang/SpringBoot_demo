package cn.ecomb.spring.batch.config;

import cn.ecomb.spring.batch.entity.Person;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/4/20.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    DataSource dataSource;

    Logger logger = LoggerFactory.getLogger(BatchConfig.class);

    /**
     * 注册脚本的容器
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public JobRepository jobRepository(DataSource dataSource,
                                       PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("MySQL");

        return jobRepositoryFactoryBean.getObject();
    }

    /**
     * 用来启动 Job 的接口
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource,
                                         PlatformTransactionManager transactionManager) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
        return jobLauncher;
    }

    @Bean
    public Job importJob(JobBuilderFactory jobs, Step s1, Step s2) {
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(s2)
                .end()
                .listener(myJobListener())
                .build();
    }

    @Bean(name = "s1")
    public Step step1(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("step1")
                .<Person, Person>chunk(1)
                .reader(reader())
                .processor(processor())
                .writer(logWriter())
                .build();

    }

    @Bean(name = "s2")
    public Step step2(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("step2")
                .<Person, Person>chunk(1)
                .reader(reader2())
                .writer(logWriter())
                .build();

    }

    @Bean
    public ItemReader<Person> reader2() {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("sample_data_2.csv"));
        reader.setLineMapper(new DefaultLineMapper<Person>() {
            {
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
                    {
                        setTargetType(Person.class);
                    }
                });
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "firstName", "lastName" });
                    }
                });
            }
        });
        reader.setLinesToSkip(3);
        return reader;
    }

    @Bean
    public ItemReader<Person> reader() {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("sample_data.csv"));
        reader.setLineMapper(new DefaultLineMapper<Person>() {
            {
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
                    {
                        setTargetType(Person.class);
                    }
                });
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "firstName", "lastName" });
                    }
                });
            }
        });
        return reader;
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        return new MyItemProcessor();
    }

    @Bean
    public ItemWriter<Person> dbWriter() {
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public LogItemWriter<Person> logWriter() {
        return new LogItemWriter<Person>() {
            @Override
            public void write(List<? extends Person> items) throws Exception {
                items.stream().forEach(person -> {logger.info("person {} is ok", person.toString()); });
            }
        };
    }

    @Bean
    public MyJobListener myJobListener() {
        return new MyJobListener();
    }

}





















