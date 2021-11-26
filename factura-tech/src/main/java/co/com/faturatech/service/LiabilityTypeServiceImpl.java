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
public class LiabilityTypeServiceImpl implements LiabilityTypeService{

	@Autowired
	private LiabilityTypeRepository liabilityTypeRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(LiabilityType liabilityType)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<LiabilityType>> constraintViolations =validator.validate(liabilityType);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return liabilityTypeRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<LiabilityType> findAll(){
		log.debug("finding all LiabilityType instances");
       	return liabilityTypeRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public LiabilityType save(LiabilityType entity) throws Exception {
		log.debug("saving LiabilityType instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("LiabilityType");
		}
		
		validate(entity);	
	
		if(liabilityTypeRepository.existsById(entity.getLbltId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return liabilityTypeRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(LiabilityType entity) throws Exception {
            	log.debug("deleting LiabilityType instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("LiabilityType");
	    		}
    	
                                if(entity.getLbltId()==null){
                    throw new ZMessManager().new EmptyFieldException("lbltId");
                    }
                        
            if(liabilityTypeRepository.existsById(entity.getLbltId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getLbltId()).ifPresent(entidad->{	            	
	                													List<Clients> clientses = entidad.getClientses();
	                    	                    if(Utilities.validationsList(clientses)==true){
                       	 	throw new ZMessManager().new DeletingException("clientses");
                        }
	                													List<Emitters> emitterses = entidad.getEmitterses();
	                    	                    if(Utilities.validationsList(emitterses)==true){
                       	 	throw new ZMessManager().new DeletingException("emitterses");
                        }
	                	            });
                       

           
            
            liabilityTypeRepository.deleteById(entity.getLbltId());
            log.debug("delete LiabilityType successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting LiabilityType instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("lbltId");
            	}
            	if(liabilityTypeRepository.existsById(id)){
           			delete(liabilityTypeRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public LiabilityType update(LiabilityType entity) throws Exception {

				log.debug("updating LiabilityType instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("LiabilityType");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(liabilityTypeRepository.existsById(entity.getLbltId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return liabilityTypeRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<LiabilityType> findById(Integer lbltId) {            
            	log.debug("getting LiabilityType instance");
            	return liabilityTypeRepository.findById(lbltId);
            }
			
}
