package doyun.lee.api.brd.service;

import doyun.lee.api.brd.domain.Board;
import doyun.lee.api.cmm.utl.Pagination;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface BoardService {
    public Map<String, Object> paging(Pagination pagination, Optional<Integer> userId);


}
