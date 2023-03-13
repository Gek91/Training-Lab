package percentage.core.service;

import org.modelmapper.ModelMapper;

import java.util.List;

public interface MapperService {

	ModelMapper getMapper();

	<D> D map(Object source, Class<D> destinationType);

	<D> void map(Object source, D destinationObject);

	<D> List<D> mapAll(List<? extends Object> source, Class<D> destinationType);
}
