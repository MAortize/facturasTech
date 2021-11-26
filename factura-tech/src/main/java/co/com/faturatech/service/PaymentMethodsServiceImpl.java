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
public class PaymentMethodsServiceImpl implements PaymentMethodsService{

	@Autowired
	private PaymentMethodsRepository paymentMethodsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(PaymentMethods paymentMethods)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<PaymentMethods>> constraintViolations =validator.validate(paymentMethods);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return paymentMethodsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<PaymentMethods> findAll(){
		log.debug("finding all PaymentMethods instances");
       	return paymentMethodsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public PaymentMethods save(PaymentMethods entity) throws Exception {
		log.debug("saving PaymentMethods instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("PaymentMethods");
		}
		
		validate(entity);	
	
		if(paymentMethodsRepository.existsById(entity.getPymmtId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return paymentMethodsRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(PaymentMethods entity) throws Exception {
            	log.debug("deleting PaymentMethods instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("PaymentMethods");
	    		}
    	
                                if(entity.getPymmtId()==null){
                    throw new ZMessManager().new EmptyFieldException("pymmtId");
                    }
                        
            if(paymentMethodsRepository.existsById(entity.getPymmtId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getPymmtId()).ifPresent(entidad->{	            	
	                													List<Bills> billses = entidad.getBillses();
	                    	                    if(Utilities.validationsList(billses)==true){
                       	 	throw new ZMessManager().new DeletingException("billses");
                        }
	                	            });
                       

           
            
            paymentMethodsRepository.deleteById(entity.getPymmtId());
            log.debug("delete PaymentMethods successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting PaymentMethods instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("pymmtId");
            	}
            	if(paymentMethodsRepository.existsById(id)){
           			delete(paymentMethodsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public PaymentMethods update(PaymentMethods entity) throws Exception {

				log.debug("updating PaymentMethods instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("PaymentMethods");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(paymentMethodsRepository.existsById(entity.getPymmtId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return paymentMethodsRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<PaymentMethods> findById(Integer pymmtId) {            
            	log.debug("getting PaymentMethods instance");
            	return paymentMethodsRepository.findById(pymmtId);
            }
			
}
