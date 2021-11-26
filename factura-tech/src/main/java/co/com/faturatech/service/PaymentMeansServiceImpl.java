package  co.com.faturatech.service;


import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.com.faturatech.exception.*;
import co.com.faturatech.repository.*;
import co.com.faturatech.utility.Utilities;

import co.com.faturatech.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
@Slf4j
public class PaymentMeansServiceImpl implements PaymentMeansService{

	@Autowired
	private PaymentMeansRepository paymentMeansRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(PaymentMeans paymentMeans)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<PaymentMeans>> constraintViolations =validator.validate(paymentMeans);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return paymentMeansRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<PaymentMeans> findAll(){
		log.debug("finding all PaymentMeans instances");
       	return paymentMeansRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public PaymentMeans save(PaymentMeans entity) throws Exception {
		log.debug("saving PaymentMeans instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("PaymentMeans");
		}
		
		validate(entity);	
	
		if(paymentMeansRepository.existsById(entity.getPymmId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return paymentMeansRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(PaymentMeans entity) throws Exception {
            	log.debug("deleting PaymentMeans instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("PaymentMeans");
	    		}
    	
                                if(entity.getPymmId()==null){
                    throw new ZMessManager().new EmptyFieldException("pymmId");
                    }
                        
            if(paymentMeansRepository.existsById(entity.getPymmId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getPymmId()).ifPresent(entidad->{	            	
	                													List<Bills> billses = entidad.getBillses();
	                    	                    if(Utilities.validationsList(billses)==true){
                       	 	throw new ZMessManager().new DeletingException("billses");
                        }
	                	            });
                       

           
            
            paymentMeansRepository.deleteById(entity.getPymmId());
            log.debug("delete PaymentMeans successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting PaymentMeans instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("pymmId");
            	}
            	if(paymentMeansRepository.existsById(id)){
           			delete(paymentMeansRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public PaymentMeans update(PaymentMeans entity) throws Exception {

				log.debug("updating PaymentMeans instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("PaymentMeans");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(paymentMeansRepository.existsById(entity.getPymmId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return paymentMeansRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<PaymentMeans> findById(Integer pymmId) {            
            	log.debug("getting PaymentMeans instance");
            	return paymentMeansRepository.findById(pymmId);
            }
			
}
