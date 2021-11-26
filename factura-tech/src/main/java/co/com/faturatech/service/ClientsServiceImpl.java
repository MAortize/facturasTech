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
public class ClientsServiceImpl implements ClientsService{

	@Autowired
	private ClientsRepository clientsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Clients clients)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Clients>> constraintViolations =validator.validate(clients);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return clientsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Clients> findAll(){
		log.debug("finding all Clients instances");
       	return clientsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Clients save(Clients entity) throws Exception {
		log.debug("saving Clients instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Clients");
		}
		
		validate(entity);	
	
		if(clientsRepository.existsById(entity.getClnId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return clientsRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Clients entity) throws Exception {
            	log.debug("deleting Clients instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Clients");
	    		}
    	
                                if(entity.getClnId()==null){
                    throw new ZMessManager().new EmptyFieldException("clnId");
                    }
                        
            if(clientsRepository.existsById(entity.getClnId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getClnId()).ifPresent(entidad->{	            	
	                													List<Bills> billses = entidad.getBillses();
	                    	                    if(Utilities.validationsList(billses)==true){
                       	 	throw new ZMessManager().new DeletingException("billses");
                        }
	                	            });
                       

           
            
            clientsRepository.deleteById(entity.getClnId());
            log.debug("delete Clients successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Clients instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("clnId");
            	}
            	if(clientsRepository.existsById(id)){
           			delete(clientsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Clients update(Clients entity) throws Exception {

				log.debug("updating Clients instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Clients");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(clientsRepository.existsById(entity.getClnId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return clientsRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Clients> findById(Integer clnId) {            
            	log.debug("getting Clients instance");
            	return clientsRepository.findById(clnId);
            }
			
}
