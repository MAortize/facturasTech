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
public class EmittersServiceImpl implements EmittersService{

	@Autowired
	private EmittersRepository emittersRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Emitters emitters)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Emitters>> constraintViolations =validator.validate(emitters);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return emittersRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Emitters> findAll(){
		log.debug("finding all Emitters instances");
       	return emittersRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Emitters save(Emitters entity) throws Exception {
		log.debug("saving Emitters instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Emitters");
		}
		
		validate(entity);	
	
		if(emittersRepository.existsById(entity.getEmtId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return emittersRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Emitters entity) throws Exception {
            	log.debug("deleting Emitters instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Emitters");
	    		}
    	
                                if(entity.getEmtId()==null){
                    throw new ZMessManager().new EmptyFieldException("emtId");
                    }
                        
            if(emittersRepository.existsById(entity.getEmtId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getEmtId()).ifPresent(entidad->{	            	
	                													List<Bills> billses = entidad.getBillses();
	                    	                    if(Utilities.validationsList(billses)==true){
                       	 	throw new ZMessManager().new DeletingException("billses");
                        }
	                	            });
                       

           
            
            emittersRepository.deleteById(entity.getEmtId());
            log.debug("delete Emitters successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Emitters instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("emtId");
            	}
            	if(emittersRepository.existsById(id)){
           			delete(emittersRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Emitters update(Emitters entity) throws Exception {

				log.debug("updating Emitters instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Emitters");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(emittersRepository.existsById(entity.getEmtId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return emittersRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Emitters> findById(Integer emtId) {            
            	log.debug("getting Emitters instance");
            	return emittersRepository.findById(emtId);
            }
			
}
