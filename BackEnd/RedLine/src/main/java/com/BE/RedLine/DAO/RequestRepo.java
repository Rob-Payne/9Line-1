package com.BE.RedLine.DAO;

import com.BE.RedLine.Model.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepo extends CrudRepository<Request, Long> {
   //Optional<Request> findByCallSign(String callSign) throws IllegalArgumentException;
   Optional<Request> findByResponder(String responder) throws IllegalArgumentException;

   public Iterable<Request> getRequestsByResponder(String responder);
}
