package com.example.soccer_1.service;

import com.example.soccer_1.dao.SoccerV1Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SoccerV1Service {

    @Autowired
    SoccerV1Dao v1Dao;

    /* 전체리스트 조회*/
    public List<Map<String, String>> doSoccerList() {

        List<Map<String, String>> list = v1Dao.doSoccerList();

        return list;

    }

    /* 전체리스트 - 오버로딩 */
    // 메서드 이름은 같지만 파라미터가 다름-> 오버로딩
    public List<Map<String, String>> doSoccerList(String strStart_date, String strEnd_date, String strName, String strKind) {

        List<Map<String, String>> list = v1Dao.doSoccerList( strStart_date, strEnd_date, strName, strKind);
        return list;
    }

    /* 데이터 입력*/
    public int doInsert(String name, String kind, String price) {
        int intI = v1Dao.doInsert(name, kind, price);
        return intI;
    }

    /* 가져오기 */
    public Map<String, String> doListOne(String strSoccer_id) {
        Map<String, String> map = v1Dao.doListOne(strSoccer_id);
        return map;
    }

    /* 수정하기 Post */
    public int doUpdate(String strSoccer_id, String strName, String strKind, String strPrice) {
        int intI = v1Dao.doUpdate(strSoccer_id, strName, strKind, strPrice);
        return intI;
    }

    /* 데이터 삭제*/
    public int doDelete(String strSoccer_id) {
        int intI = v1Dao.doDelete(strSoccer_id);

        return intI;
    }
}
