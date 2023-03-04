package farooq.com.Pass.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import farooq.com.Pass.entity.Pass;
import farooq.com.Pass.exception.ResourceNotFoundException;
import farooq.com.Pass.playload.PassDto;
import farooq.com.Pass.repository.PassRepository;

@Service
public class PassServiceImpl implements PassService{

	
	private PassRepository Passrepo;
	private ModelMapper mapper;
	public PassServiceImpl(PassRepository passrepo,ModelMapper mapper) {
		super();
		Passrepo = passrepo;
		mapper=mapper;
	}

	@Override
	public PassDto createallPass(PassDto passDto) {
		Pass pass = mapToEntity(passDto);
		Pass newpass = Passrepo.save(pass);
		PassDto dto = mapToDto(newpass);
		return dto;
	}

	private PassDto mapToDto(Pass newpass) {
	//PassDto postDto=	mapper.map(newpass, PassDto.class);
		PassDto postDto = new PassDto();
		postDto.setId(newpass.getId());
		postDto.setName(newpass.getName());
		postDto.setEmail(newpass.getEmail());

		postDto.setMobile(newpass.getMobile());
		postDto.setTitle(newpass.getTitle());
		return postDto;
	}

	private Pass mapToEntity(PassDto passDto) {
		//Pass map = mapper.map(passDto, Pass.class);
		Pass pass =new Pass();
		pass.setName(passDto.getName());
		pass.setEmail(passDto.getEmail());
		pass.setTitle(passDto.getTitle());
		pass.setMobile(passDto.getMobile());
		//return map;
		return pass;
	}

	@Override
	public List<PassDto> getAllPass() {
		List<Pass> pass = Passrepo.findAll();
		return pass.stream().map(passs->mapToDto(passs)).collect(Collectors.toList());
	}

	@Override
	public PassDto getById(long id) {
		Pass pass =Passrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pass", "id", id));
		return mapToDto(pass);
	}

	@Override
	public Pass updateById(long id,PassDto  passDto) {
		Pass pass = Passrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pass", "id", id));
		pass.setEmail(passDto.getEmail());
		pass.setMobile(passDto.getMobile());
		pass.setTitle(passDto.getTitle());
		pass.setName(passDto.getName());
		return pass;
	}

	@Override
	public void deleteById(long id) {
		Pass pass =Passrepo.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Pass", "id", id));
		Passrepo.delete(pass);
	}

	
	
	
	
}
