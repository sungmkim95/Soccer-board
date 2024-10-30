package com.example.soccer_1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SoccerV1Dao {

    /* 전체리스트 조회*/
    List<Map<String, String>> doSoccerList() ;

    /* 전체리스트 조회* - 함수 오버로딩 */
    List<Map<String, String>> doSoccerList(String strStart_date, String strEnd_date, String strName, String strKind);

    /* 등록 */
    int doInsert(String name, String kind, String price);

    /* 가져오기 */
    Map<String, String> doListOne(String strSoccer_id);

    /* 수정하기 Post */
    int doUpdate(String strSoccer_id, String strName, String strKind, String strPrice);

    /* 1 row 삭제*/
    int doDelete(String strSoccer_id);
}
