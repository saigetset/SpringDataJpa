package com.sai.service;

import java.util.List;

import com.sai.projections.Projections;

public interface IStudentService {
	public <T extends Projections>List<T> getStudentIdAndNameByCityInAndAgeBetween(String[] cities, Integer ageAbove, Integer ageBelow, Class<T> cls);
}
