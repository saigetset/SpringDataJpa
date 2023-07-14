package com.sai.service;

import java.util.List;

import com.sai.projections.ResultProjection;

public interface IStudentService {
	public List<ResultProjection> getStudentIdAndNameByCityInAndAgeBetween(String[] cities, Integer ageAbove, Integer ageBelow);
}
