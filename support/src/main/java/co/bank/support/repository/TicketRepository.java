package co.bank.support.repository;

import co.bank.support.model.Ticket;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;

@Repository
public interface TicketRepository extends CassandraRepository<Ticket, UID> {
}
