package com.subway.review;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
* ≥ı…Û¡–±Ì‰∏öÂä°Á±?
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/
@Service
public class ReviewService extends BaseService {


@Autowired
ReviewRepository reviewRepository;

public List
<Review> findAll() {
return  reviewRepository.findAll();
}



public Page< Review> findAll(Pageable pageable) {
return  reviewRepository.findAll(pageable);
}


public  Review findById(Long id) {
return  reviewRepository.getOne(id);
}

}
