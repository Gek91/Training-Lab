package percentage.core.service.Impl;

import org.modelmapper.ModelMapper;
import percentage.core.service.MapperService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapperServiceImpl implements MapperService {

	private ModelMapper mapper;

	public MapperServiceImpl() {
		this.mapper = new ModelMapper();
	}

	@Override
	public ModelMapper getMapper() {
		return this.mapper;
	}

	@Override
	public <D> D map(Object source, Class<D> destinationType) {
		return mapper.map(source, destinationType);
	}

	@Override
	public <D> void map(Object source, D destinationObject) {
		mapper.map(source, destinationObject);
	}

	@Override
	public <D> List<D> mapAll(List<? extends Object> source, Class<D> destinationType) {
		List<D> output = new ArrayList<>();
		if (source != null) {

			return source.stream().map(elem -> map(elem, destinationType)).collect(Collectors.toList());

		}

		return output;
	}
}
