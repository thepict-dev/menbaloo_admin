/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pict_admin.service.impl;

import java.util.List;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import pict_admin.service.AdminVO;
import pict_admin.service.PictDefaultVO;
import pict_admin.service.PictService;
import pict_admin.service.PictVO;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("pictService")
public class PictServiceImpl extends EgovAbstractServiceImpl implements PictService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PictServiceImpl.class);

	/** SampleDAO */
	// TODO ibatis 사용
//	@Resource(name = "pictDAO")
//	private PictDAO pictDAO;
	// TODO mybatis 사용
    @Resource(name="pictMapper")
	private PictMapper pictMapper;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;


	@Override
	public Integer menbal_list_cnt(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.menbal_list_cnt(pictVO);
	}

	@Override
	public List<PictVO> menbal_list(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.menbal_list(pictVO);
	}

	@Override
	public void menbal_del(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.menbal_del(pictVO);
	}

	@Override
	public Integer feed_list_cnt(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.feed_list_cnt(pictVO);
	}

	@Override
	public List<PictVO> feed_list(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.feed_list(pictVO);
	}

	@Override
	public void feed_del(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.feed_del(pictVO);
	}

	@Override
	public void feed_reply_del(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.feed_reply_del(pictVO);
	}

	@Override
	public List<PictVO> feed_reply_list(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.feed_reply_list(pictVO);
	}

	@Override
	public Integer history_list_cnt(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.history_list_cnt(pictVO);
	}

	@Override
	public List<PictVO> history_list(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.history_list(pictVO);
	}

	@Override
	public void history_del(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.history_del(pictVO);
	}

	@Override
	public Integer event_list_cnt(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.event_list_cnt(pictVO);
	}

	@Override
	public List<PictVO> event_list(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.event_list(pictVO);
	}

	@Override
	public PictVO event_list_one(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.event_list_one(pictVO);
	}

	@Override
	public void event_update(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.event_update(pictVO);
	}

	@Override
	public void event_insert(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.event_insert(pictVO);
	}

	@Override
	public void event_delete(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.event_delete(pictVO);
	}

	@Override
	public Integer course_list_cnt(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.course_list_cnt(pictVO);
	}

	@Override
	public List<PictVO> course_list(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.course_list(pictVO);
	}

	@Override
	public PictVO course_list_one(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.course_list_one(pictVO);
	}

	@Override
	public void course_update(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.course_update(pictVO);
	}

	@Override
	public void course_insert(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.course_insert(pictVO);
	}

	@Override
	public void course_delete(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.course_delete(pictVO);
	}

	@Override
	public Integer popup_list_cnt(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.popup_list_cnt(pictVO);
	}

	@Override
	public List<PictVO> popup_list(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.popup_list(pictVO);
	}

	@Override
	public PictVO popup_list_one(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		return pictMapper.popup_list_one(pictVO);
	}

	@Override
	public void popup_update(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.popup_update(pictVO);
	}

	@Override
	public void popup_insert(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.popup_insert(pictVO);
	}

	@Override
	public void popup_delete(PictVO pictVO) throws Exception {
		// TODO Auto-generated method stub
		pictMapper.popup_delete(pictVO);
	}



}
