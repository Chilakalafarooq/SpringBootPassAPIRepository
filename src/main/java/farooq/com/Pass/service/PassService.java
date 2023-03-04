package farooq.com.Pass.service;


import java.util.List;

import org.springframework.util.MultiValueMap;

import farooq.com.Pass.entity.Pass;
import farooq.com.Pass.playload.PassDto;

public interface PassService {

PassDto createallPass(PassDto passDto);
List<PassDto> getAllPass();
PassDto  getById(long id);
Pass updateById(long id,PassDto  passDto);
void deleteById(long id);



}
