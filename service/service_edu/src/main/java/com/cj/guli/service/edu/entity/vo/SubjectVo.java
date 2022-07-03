package com.cj.guli.service.edu.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-07-03 19:4:01
 */
@Data
public class SubjectVo {

	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private Integer sort;
	private List<SubjectVo> children = new ArrayList<>();
}
