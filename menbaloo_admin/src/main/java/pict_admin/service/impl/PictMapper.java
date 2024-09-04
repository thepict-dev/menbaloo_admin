/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
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


import egovframework.rte.psl.dataaccess.mapper.Mapper;
import pict_admin.service.AdminVO;
import pict_admin.service.PictDefaultVO;
import pict_admin.service.PictVO;

/**
 * sample에 관한 데이터처리 매퍼 클래스
 *
 * @author  표준프레임워크센터
 * @since 2014.01.24
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2014.01.24        표준프레임워크센터          최초 생성
 *
 * </pre>
 */
@Mapper("pictMapper")
public interface PictMapper {
	
	Integer menbal_list_cnt(PictVO pictVO) throws Exception;

	List<PictVO> menbal_list(PictVO pictVO) throws Exception;

	void menbal_del(PictVO pictVO)throws Exception;

	Integer feed_list_cnt(PictVO pictVO)throws Exception;

	List<PictVO> feed_list(PictVO pictVO) throws Exception;

	void feed_del(PictVO pictVO) throws Exception;

	void feed_reply_del(PictVO pictVO) throws Exception;

	List<PictVO> feed_reply_list(PictVO pictVO) throws Exception;

	Integer history_list_cnt(PictVO pictVO) throws Exception;

	List<PictVO> history_list(PictVO pictVO) throws Exception;

	void history_del(PictVO pictVO) throws Exception;

	Integer event_list_cnt(PictVO pictVO) throws Exception;

	List<PictVO> event_list(PictVO pictVO) throws Exception;

	PictVO event_list_one(PictVO pictVO) throws Exception;

	void event_update(PictVO pictVO) throws Exception;

	void event_insert(PictVO pictVO) throws Exception;

	void event_delete(PictVO pictVO) throws Exception;

	Integer course_list_cnt(PictVO pictVO) throws Exception; 

	List<PictVO> course_list(PictVO pictVO) throws Exception;

	PictVO course_list_one(PictVO pictVO) throws Exception;

	void course_update(PictVO pictVO) throws Exception;

	void course_insert(PictVO pictVO) throws Exception;

	void course_delete(PictVO pictVO) throws Exception;
}
