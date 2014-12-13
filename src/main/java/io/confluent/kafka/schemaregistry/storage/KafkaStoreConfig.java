package io.confluent.kafka.schemaregistry.storage;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

import java.util.Map;

import static org.apache.kafka.common.config.ConfigDef.Range.atLeast;

public class KafkaStoreConfig extends AbstractConfig {

    /** <code>kafkastore.connection.url</code> */
    public static final String KAFKASTORE_CONNECTION_URL_CONFIG = "kafkastore.connection.url";
    private static final String KAFKASTORE_CONNECTION_URL_DOC = "Zookeeper url for the Kafka cluster";

    /** <code>kafkastore.zk.session.timeout.ms</code> */
    public static final String KAFKASTORE_ZK_SESSION_TIMEOUT_MS_CONFIG
        = "kafkastore.zk.session.timeout.ms";
    private static final String KAFKASTORE_ZK_SESSION_TIMEOUT_MS_DOC = "Zookeeper session timeout";

    /** <code>kafkastore.topic</code> */
    public static final String KAFKASTORE_TOPIC_CONFIG = "kafkastore.topic";
    private static final String KAFKASTORE_TOPIC_DOC = "The durable single partition topic that acts" +
        "as the durable log for the data";

    /** <code>kafkastore.timeout.ms</code> */
    public static final String KAFKASTORE_TIMEOUT_CONFIG = "kafkastore.timeout.ms";
    private static final String KAFKASTORE_TIMEOUT_DOC = "The timeout for an operation on the Kafka" +
        " store";

    private static final ConfigDef config = new ConfigDef()
        .define(KAFKASTORE_CONNECTION_URL_CONFIG, Type.STRING, Importance.HIGH,
            KAFKASTORE_CONNECTION_URL_DOC)
        .define(KAFKASTORE_ZK_SESSION_TIMEOUT_MS_CONFIG, Type.INT, 10000, atLeast(0), Importance.LOW,
            KAFKASTORE_ZK_SESSION_TIMEOUT_MS_DOC)
        .define(KAFKASTORE_TOPIC_CONFIG, Type.STRING, Importance.HIGH, KAFKASTORE_TOPIC_DOC)
        .define(KAFKASTORE_TIMEOUT_CONFIG, Type.INT, 500, atLeast(0), Importance.MEDIUM,
    KAFKASTORE_TIMEOUT_DOC);

    public KafkaStoreConfig(ConfigDef arg0, Map<?, ?> arg1) {
        super(arg0, arg1);
    }

    KafkaStoreConfig(Map<? extends Object, ? extends Object> props) {
        super(config, props);
    }

    public static void main(String[] args) {
        System.out.println(config.toHtmlTable());
    }

}
