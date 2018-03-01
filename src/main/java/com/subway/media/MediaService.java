package com.subway.media;

import java.util.List;
import java.util.Map;

import com.subway.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ��ý�����业务�?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MediaService extends BaseService {


    @Autowired
    MediaRepository mediaRepository;

    public List
            <Media> findAll() {
        return mediaRepository.findAll();
    }


    public Page<Media> findAll(Pageable pageable) {
        return mediaRepository.findAll(pageable);
    }


    public Media findById(Long id) {
        return mediaRepository.getOne(id);
    }

}
