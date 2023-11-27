package co.bank.support.model;

import jakarta.persistence.Table;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.sql.Date;
import java.util.UUID;

@Table
public class Ticket {
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID id;
    private String description;
    private Integer account;
    private Date date;
    private String status;
}
