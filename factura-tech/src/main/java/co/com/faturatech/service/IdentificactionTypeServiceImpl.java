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
public class IdentificactionTypeServiceImpl implements IdentificactionTypeService{

	@Autowired
	private IdentificactionTypeRepository identificactionTypeRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(IdentificactionType identificactionType)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<IdentificactionType>> constraintViolations =validator.validate(identificactionType);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return identificactionTypeRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<IdentificactionType> findAll(){
		log.debug("finding all IdentificactionType instances");
       	return identificactionTypeRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public IdentificactionType save(IdentificactionType entity) throws Exception {
		log.debug("saving IdentificactionType instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("IdentificactionType");
		}
		
		validate(entity);	
	
		if(identificactionTypeRepository.existsById(entity.getIdtId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return identificactionTypeRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(IdentificactionType entity) throws Exception {
            	log.debug("deleting IdentificactionType instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("IdentificactionType");
	    		}
    	
                                if(entity.getIdtId()==null){
                    throw new ZMessManager().new EmptyFieldException("idtId");
                    }
                        
            if(identificactionTypeRepository.existsById(entity.getIdtId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getIdtId()).ifPresent(entidad->{	            	
	                													List<Clients> clientses = entidad.getClientses();
	                    	                    if(Utilities.validationsList(clientses)==true){
                       	 	throw new ZMessManager().new DeletingException("clientses");
                        }
	                													List<Emitters> emitterses = entidad.getEmitterses();
	                    	                    if(Utilities.validationsList(emitterses)==true){
                       	 	throw new ZMessManager().new DeletingException("emitterses");
                        }
	                	            });
                       

           
            
            identificactionTypeRepository.deleteById(entity.getIdtId());
            log.debug("delete IdentificactionType successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting IdentificactionType instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("idtId");
            	}
            	if(identificactionTypeRepository.existsById(id)){
           			delete(identificactionTypeRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public IdentificactionType update(IdentificactionType entity) throws Exception {

				log.debug("updating IdentificactionType instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("IdentificactionType");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(identificactionTypeRepository.existsById(entity.getIdtId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return identificactionTypeRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<IdentificactionType> findById(Integer idtId) {            
            	log.debug("getting IdentificactionType instance");
            	return identificactionTypeRepository.findById(idtId);
            }
			
}
