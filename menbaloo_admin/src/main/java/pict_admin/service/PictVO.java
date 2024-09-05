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

/**
 * @Class Name : SampleVO.java
 * @Description : SampleVO Class
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
public class PictVO extends PictDefaultVO {

	private static final long serialVersionUID = 1L;

	private int idx;
	private boolean api;
	private String saveType;
	private int order_val;
	private String user_id;
	private String max_idx;
	private String target_table;
	private String reg_date;
	private String key_id;
	private String title;
	private String content;
	private String coin_text;
	private String type;
	private String password;
	private String name;
	private String position_x;
	private String position_y;
	private String position_z;
	private String rotation_x;
	private String rotation_y;
	private String rotation_z;
	private String cloth_id;
	private String face_id;
	private String hair_id;
	private String shoes_id;
	private String body;
	
	private String cloth;
	private String face;
	private String hair;
	private String shoes;
	
	private String use_at;
	private String link_url;
	private String professor;
	private String reg_id;
	private String std_num;
	private String lecture_id;
	
	private String in_date;
	private String out_date;
	private String in_out;
	private String timediff;
	private String category;
	private String category_id;
	private String category_cnt;
	private String week;
	private String id;
	private String email;
	private String nick_name;
	private String mobile;
	private String search_category;
	private String search_name;
	private String search_title;
	
	
	private String search_id;
	private String search_nickname;
	private String search_mobile;
	private String search_email;

	private String whole_timediff;
	private String search_text;
	private String order_by;
	private String active_ty;
	private String campus;
	private String text;
	private String professor_id;
	private String campus_id;
	private String week_cha;
	private String week_count;
	private String zoom_no;
	private String zoom_pw;
	private String time;
	private String url;
	private String file;
	private String video_type;
	private String img_url;
	private String depart;
	private String img_url2;
	private String wish_id;
	private String reply;
	private String title1;
	private String title2;
	private String img_url1;
	private String link_url1;
	private String link_url2;
	private String client;
	private String img_thumb;
	private String img_url3;
	private String img_url4;
	private String img_url5;
	private String team;
	private String position;
	private String name_en;
	private String moto;
	private String year;
	private String del_img_url;
	private String press;
	private String sub_category;
	private String person;
	private String vote;
	private String cnt;
	private String file_url;
	private String brand_title1;
	private String brand_title2;
	private String brand_title3;
	private String brand_title4;
	private String brand_title5;
	private String brand_title6;
	private String brand_link1;
	private String brand_link2;
	private String brand_link3;
	private String brand_link4;
	private String brand_link5;
	private String brand_link6;
	private String ext;
	private String en_title;
	private String ox;
	private String target_date;
	private String location;
	private String day;
	private String month;
	private String heat;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	private String from_date;
	private String to_date;
	private String gift;
	private String height;
	private String bong;
	private String tel;
	private String home_link;
	private String introduce;
	private String img_1;
	private String img_2;
	private String img_3;
	private String img_4;
	private String img_5;
	private String summer_info;
	private String address;
	private String location_x;
	private String location_y;
	private String link_text_1;
	private String link_text_2;
	private String link_1;
	private String link_2;
	private String course_title_1;
	private String course_title_2;
	private String course_info_1;
	private String course_info_2;
	private String higher;
	private String lower;
	
	private int pageNumber;
	private int startNumber;
	private int limit;
	private int totalPage;
	private int offset;
	private int lastPage;
	private int startPage;
	private int endPage;
	
	private String nickname;
	
	private String weight;
	private String gender;
	private String phone;
	private String created_at;
	private String feed_id;
	private String image_url;
	private String like_cnt;
	private String report_yn;
	private String comment;
	
	private String walking_id;
	private String steps;
	private String distance;
	private String average_speed;
	private String calories;
	private String duration;
	private String start;
	private String end;
	private String image;
	
	private String event_date;
	
	private String administrative;
	private String local;
	private String length;
	private String course_type;
	private String send_type;
	private String toilet;
	
	private String foot;
	private String management;
	private String vr_link;
	private String thumb_url;
	
	
	
	
	public String getAdministrative() {
		return administrative;
	}
	public void setAdministrative(String administrative) {
		this.administrative = administrative;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public String getSend_type() {
		return send_type;
	}
	public void setSend_type(String send_type) {
		this.send_type = send_type;
	}
	public String getToilet() {
		return toilet;
	}
	public void setToilet(String toilet) {
		this.toilet = toilet;
	}
	public String getFoot() {
		return foot;
	}
	public void setFoot(String foot) {
		this.foot = foot;
	}
	public String getManagement() {
		return management;
	}
	public void setManagement(String management) {
		this.management = management;
	}
	public String getVr_link() {
		return vr_link;
	}
	public void setVr_link(String vr_link) {
		this.vr_link = vr_link;
	}
	public String getThumb_url() {
		return thumb_url;
	}
	public void setThumb_url(String thumb_url) {
		this.thumb_url = thumb_url;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public String getWalking_id() {
		return walking_id;
	}
	public void setWalking_id(String walking_id) {
		this.walking_id = walking_id;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getAverage_speed() {
		return average_speed;
	}
	public void setAverage_speed(String average_speed) {
		this.average_speed = average_speed;
	}
	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFeed_id() {
		return feed_id;
	}
	public void setFeed_id(String feed_id) {
		this.feed_id = feed_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(String like_cnt) {
		this.like_cnt = like_cnt;
	}
	public String getReport_yn() {
		return report_yn;
	}
	public void setReport_yn(String report_yn) {
		this.report_yn = report_yn;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getHigher() {
		return higher;
	}
	public void setHigher(String higher) {
		this.higher = higher;
	}
	public String getLower() {
		return lower;
	}
	public void setLower(String lower) {
		this.lower = lower;
	}
	public String getCourse_title_1() {
		return course_title_1;
	}
	public void setCourse_title_1(String course_title_1) {
		this.course_title_1 = course_title_1;
	}
	public String getCourse_title_2() {
		return course_title_2;
	}
	public void setCourse_title_2(String course_title_2) {
		this.course_title_2 = course_title_2;
	}
	public String getCourse_info_1() {
		return course_info_1;
	}
	public void setCourse_info_1(String course_info_1) {
		this.course_info_1 = course_info_1;
	}
	public String getCourse_info_2() {
		return course_info_2;
	}
	public void setCourse_info_2(String course_info_2) {
		this.course_info_2 = course_info_2;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBong() {
		return bong;
	}
	public void setBong(String bong) {
		this.bong = bong;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHome_link() {
		return home_link;
	}
	public void setHome_link(String home_link) {
		this.home_link = home_link;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImg_1() {
		return img_1;
	}
	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}
	public String getImg_2() {
		return img_2;
	}
	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}
	public String getImg_3() {
		return img_3;
	}
	public void setImg_3(String img_3) {
		this.img_3 = img_3;
	}
	public String getImg_4() {
		return img_4;
	}
	public void setImg_4(String img_4) {
		this.img_4 = img_4;
	}
	public String getImg_5() {
		return img_5;
	}
	public void setImg_5(String img_5) {
		this.img_5 = img_5;
	}
	public String getSummer_info() {
		return summer_info;
	}
	public void setSummer_info(String summer_info) {
		this.summer_info = summer_info;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation_x() {
		return location_x;
	}
	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}
	public String getLocation_y() {
		return location_y;
	}
	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}
	public String getLink_text_1() {
		return link_text_1;
	}
	public void setLink_text_1(String link_text_1) {
		this.link_text_1 = link_text_1;
	}
	public String getLink_text_2() {
		return link_text_2;
	}
	public void setLink_text_2(String link_text_2) {
		this.link_text_2 = link_text_2;
	}
	public String getLink_1() {
		return link_1;
	}
	public void setLink_1(String link_1) {
		this.link_1 = link_1;
	}
	public String getLink_2() {
		return link_2;
	}
	public void setLink_2(String link_2) {
		this.link_2 = link_2;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getImg5() {
		return img5;
	}
	public void setImg5(String img5) {
		this.img5 = img5;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getHeat() {
		return heat;
	}
	public void setHeat(String heat) {
		this.heat = heat;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTarget_date() {
		return target_date;
	}
	public void setTarget_date(String target_date) {
		this.target_date = target_date;
	}
	public String getOx() {
		return ox;
	}
	public void setOx(String ox) {
		this.ox = ox;
	}
	public String getEn_title() {
		return en_title;
	}
	public void setEn_title(String en_title) {
		this.en_title = en_title;
	}
	public String getBrand_title6() {
		return brand_title6;
	}
	public void setBrand_title6(String brand_title6) {
		this.brand_title6 = brand_title6;
	}
	public String getBrand_link6() {
		return brand_link6;
	}
	public void setBrand_link6(String brand_link6) {
		this.brand_link6 = brand_link6;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getBrand_title1() {
		return brand_title1;
	}
	public void setBrand_title1(String brand_title1) {
		this.brand_title1 = brand_title1;
	}
	public String getBrand_title2() {
		return brand_title2;
	}
	public void setBrand_title2(String brand_title2) {
		this.brand_title2 = brand_title2;
	}
	public String getBrand_title3() {
		return brand_title3;
	}
	public void setBrand_title3(String brand_title3) {
		this.brand_title3 = brand_title3;
	}
	public String getBrand_title4() {
		return brand_title4;
	}
	public void setBrand_title4(String brand_title4) {
		this.brand_title4 = brand_title4;
	}
	public String getBrand_title5() {
		return brand_title5;
	}
	public void setBrand_title5(String brand_title5) {
		this.brand_title5 = brand_title5;
	}
	public String getBrand_link1() {
		return brand_link1;
	}
	public void setBrand_link1(String brand_link1) {
		this.brand_link1 = brand_link1;
	}
	public String getBrand_link2() {
		return brand_link2;
	}
	public void setBrand_link2(String brand_link2) {
		this.brand_link2 = brand_link2;
	}
	public String getBrand_link3() {
		return brand_link3;
	}
	public void setBrand_link3(String brand_link3) {
		this.brand_link3 = brand_link3;
	}
	public String getBrand_link4() {
		return brand_link4;
	}
	public void setBrand_link4(String brand_link4) {
		this.brand_link4 = brand_link4;
	}
	public String getBrand_link5() {
		return brand_link5;
	}
	public void setBrand_link5(String brand_link5) {
		this.brand_link5 = brand_link5;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	public String getSub_category() {
		return sub_category;
	}
	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getDel_img_url() {
		return del_img_url;
	}
	public void setDel_img_url(String del_img_url) {
		this.del_img_url = del_img_url;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getImg_thumb() {
		return img_thumb;
	}
	public void setImg_thumb(String img_thumb) {
		this.img_thumb = img_thumb;
	}
	public String getImg_url3() {
		return img_url3;
	}
	public void setImg_url3(String img_url3) {
		this.img_url3 = img_url3;
	}
	public String getImg_url4() {
		return img_url4;
	}
	public void setImg_url4(String img_url4) {
		this.img_url4 = img_url4;
	}
	public String getImg_url5() {
		return img_url5;
	}
	public void setImg_url5(String img_url5) {
		this.img_url5 = img_url5;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public String getMoto() {
		return moto;
	}
	public void setMoto(String moto) {
		this.moto = moto;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLink_url1() {
		return link_url1;
	}
	public void setLink_url1(String link_url1) {
		this.link_url1 = link_url1;
	}
	public String getLink_url2() {
		return link_url2;
	}
	public void setLink_url2(String link_url2) {
		this.link_url2 = link_url2;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getImg_url1() {
		return img_url1;
	}
	public void setImg_url1(String img_url1) {
		this.img_url1 = img_url1;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWish_id() {
		return wish_id;
	}
	public void setWish_id(String wish_id) {
		this.wish_id = wish_id;
	}
	public String getImg_url2() {
		return img_url2;
	}
	public void setImg_url2(String img_url2) {
		this.img_url2 = img_url2;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getVideo_type() {
		return video_type;
	}
	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getZoom_no() {
		return zoom_no;
	}
	public void setZoom_no(String zoom_no) {
		this.zoom_no = zoom_no;
	}
	public String getZoom_pw() {
		return zoom_pw;
	}
	public void setZoom_pw(String zoom_pw) {
		this.zoom_pw = zoom_pw;
	}
	public String getWeek_cha() {
		return week_cha;
	}
	public void setWeek_cha(String week_cha) {
		this.week_cha = week_cha;
	}
	public String getWeek_count() {
		return week_count;
	}
	public void setWeek_count(String week_count) {
		this.week_count = week_count;
	}
	public String getCampus_id() {
		return campus_id;
	}
	public void setCampus_id(String campus_id) {
		this.campus_id = campus_id;
	}
	public String getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(String professor_id) {
		this.professor_id = professor_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getActive_ty() {
		return active_ty;
	}
	public void setActive_ty(String active_ty) {
		this.active_ty = active_ty;
	}
	public String getOrder_by() {
		return order_by;
	}
	public void setOrder_by(String order_by) {
		this.order_by = order_by;
	}
	public String getSearch_text() {
		return search_text;
	}
	public void setSearch_text(String search_text) {
		this.search_text = search_text;
	}
	public String getWhole_timediff() {
		return whole_timediff;
	}
	public void setWhole_timediff(String whole_timediff) {
		this.whole_timediff = whole_timediff;
	}
	public String getSearch_id() {
		return search_id;
	}
	public void setSearch_id(String search_id) {
		this.search_id = search_id;
	}
	public String getSearch_nickname() {
		return search_nickname;
	}
	public void setSearch_nickname(String search_nickname) {
		this.search_nickname = search_nickname;
	}
	public String getSearch_mobile() {
		return search_mobile;
	}
	public void setSearch_mobile(String search_mobile) {
		this.search_mobile = search_mobile;
	}
	public String getSearch_email() {
		return search_email;
	}
	public void setSearch_email(String search_email) {
		this.search_email = search_email;
	}
	public String getSearch_category() {
		return search_category;
	}
	public void setSearch_category(String search_category) {
		this.search_category = search_category;
	}
	public String getSearch_name() {
		return search_name;
	}
	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}
	public String getSearch_title() {
		return search_title;
	}
	public void setSearch_title(String search_title) {
		this.search_title = search_title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getCategory_cnt() {
		return category_cnt;
	}
	public void setCategory_cnt(String category_cnt) {
		this.category_cnt = category_cnt;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTimediff() {
		return timediff;
	}
	public void setTimediff(String timediff) {
		this.timediff = timediff;
	}
	public String getIn_out() {
		return in_out;
	}
	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}
	public String getIn_date() {
		return in_date;
	}
	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}
	public String getOut_date() {
		return out_date;
	}
	public void setOut_date(String out_date) {
		this.out_date = out_date;
	}
	public String getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(String lecture_id) {
		this.lecture_id = lecture_id;
	}
	public String getStd_num() {
		return std_num;
	}
	public void setStd_num(String std_num) {
		this.std_num = std_num;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getUse_at() {
		return use_at;
	}
	public void setUse_at(String use_at) {
		this.use_at = use_at;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public String getCloth() {
		return cloth;
	}
	public void setCloth(String cloth) {
		this.cloth = cloth;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getHair() {
		return hair;
	}
	public void setHair(String hair) {
		this.hair = hair;
	}
	public String getShoes() {
		return shoes;
	}
	public void setShoes(String shoes) {
		this.shoes = shoes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition_x() {
		return position_x;
	}
	public void setPosition_x(String position_x) {
		this.position_x = position_x;
	}
	public String getPosition_y() {
		return position_y;
	}
	public void setPosition_y(String position_y) {
		this.position_y = position_y;
	}
	public String getPosition_z() {
		return position_z;
	}
	public void setPosition_z(String position_z) {
		this.position_z = position_z;
	}
	public String getRotation_x() {
		return rotation_x;
	}
	public void setRotation_x(String rotation_x) {
		this.rotation_x = rotation_x;
	}
	public String getRotation_y() {
		return rotation_y;
	}
	public void setRotation_y(String rotation_y) {
		this.rotation_y = rotation_y;
	}
	public String getRotation_z() {
		return rotation_z;
	}
	public void setRotation_z(String rotation_z) {
		this.rotation_z = rotation_z;
	}
	public String getCloth_id() {
		return cloth_id;
	}
	public void setCloth_id(String cloth_id) {
		this.cloth_id = cloth_id;
	}
	public String getFace_id() {
		return face_id;
	}
	public void setFace_id(String face_id) {
		this.face_id = face_id;
	}
	public String getHair_id() {
		return hair_id;
	}
	public void setHair_id(String hair_id) {
		this.hair_id = hair_id;
	}
	public String getShoes_id() {
		return shoes_id;
	}
	public void setShoes_id(String shoes_id) {
		this.shoes_id = shoes_id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getKey_id() {
		return key_id;
	}
	public void setKey_id(String key_id) {
		this.key_id = key_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCoin_text() {
		return coin_text;
	}
	public void setCoin_text(String coin_text) {
		this.coin_text = coin_text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getTarget_table() {
		return target_table;
	}
	public void setTarget_table(String target_table) {
		this.target_table = target_table;
	}
	public String getMax_idx() {
		return max_idx;
	}
	public void setMax_idx(String max_idx) {
		this.max_idx = max_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getOrder_val() {
		return order_val;
	}
	public void setOrder_val(int order_val) {
		this.order_val = order_val;
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	public boolean isApi() {
		return api;
	}
	public boolean api() {
		return api;
	}
	public void setApi(boolean api) {
		this.api = api;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	
	
	
}
