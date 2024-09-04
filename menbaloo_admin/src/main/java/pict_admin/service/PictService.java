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
package pict_admin.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class Name : EgovSampleService.java
 * @Description : EgovSampleService Class
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
public interface PictService {
	List<?> reference_list(PictVO pictVO) throws Exception;

	PictVO reference_list_one(PictVO pictVO) throws Exception;

	void reference_update(PictVO pictVO) throws Exception;

	void reference_insert(PictVO pictVO) throws Exception;

	void reference_delete(PictVO pictVO) throws Exception;

	void reference_file_delete(PictVO pictVO) throws Exception;

	List<?> news_list(PictVO pictVO) throws Exception;

	PictVO news_list_one(PictVO pictVO) throws Exception;

	void news_update(PictVO pictVO) throws Exception;

	void news_insert(PictVO pictVO) throws Exception; 

	void news_delete(PictVO pictVO) throws Exception;

	List<?> history_list(PictVO pictVO) throws Exception;

	PictVO history_list_one(PictVO pictVO) throws Exception;

	void history_update(PictVO pictVO) throws Exception;

	void history_insert(PictVO pictVO) throws Exception;

	void history_delete(PictVO pictVO) throws Exception;

	List<?> user_list(PictVO pictVO) throws Exception;

	PictVO user_list_one(PictVO pictVO) throws Exception;

	void user_update(PictVO pictVO) throws Exception;

	void user_insert(PictVO pictVO) throws Exception;

	void user_delete(PictVO pictVO) throws Exception;

	void user_file_delete(PictVO pictVO) throws Exception;

	void history_file_delete(PictVO pictVO) throws Exception;

	//컨텐츠관리 - 띠배너
	List<?> board_list(PictVO pictVO) throws Exception;

	PictVO board_list_one(PictVO pictVO) throws Exception;

	void board_update(PictVO pictVO) throws Exception;

	void board_insert(PictVO pictVO) throws Exception;

	void board_delete(PictVO pictVO) throws Exception;


	List<?> photo_list(PictVO pictVO) throws Exception;

	void photo_delete(PictVO pictVO) throws Exception;

	List<PictVO> status_list(PictVO pictVO) throws Exception;

	List<?> event_list(PictVO pictVO) throws Exception;

	PictVO event_list_one(PictVO pictVO) throws Exception;

	void event_update(PictVO pictVO) throws Exception;

	void event_insert(PictVO pictVO) throws Exception;

	void event_delete(PictVO pictVO) throws Exception;
	
	List<?> popup_list(PictVO pictVO) throws Exception;

	PictVO popup_list_one(PictVO pictVO) throws Exception;

	void popup_update(PictVO pictVO) throws Exception;

	void popup_insert(PictVO pictVO) throws Exception;

	void popup_delete(PictVO pictVO) throws Exception;

	List<?> mountain_list(PictVO pictVO) throws Exception;

	PictVO mountain_detail(PictVO pictVO) throws Exception;

	PictVO board_detail(PictVO pictVO) throws Exception;

	PictVO event_detail(PictVO pictVO) throws Exception;

	void mountain_count_insert(PictVO pictVO) throws Exception;


}
