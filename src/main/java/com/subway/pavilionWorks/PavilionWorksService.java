package com.subway.pavilionWorks;

import java.util.List;
import java.util.Map;

import com.subway.pavilionAuthor.PavilionAuthor;
import com.subway.service.app.BaseService;
import com.subway.utils.ConstantUtils;
import com.subway.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * չ����Ʒ��Ϣҵ����
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class PavilionWorksService extends BaseService {


    @Autowired
    PavilionWorksRepository pavilionWorksRepository;

    public List<PavilionWorks> findAll() {
        return pavilionWorksRepository.findAll();
    }


    public Page<PavilionWorks> findAll(Pageable pageable) {
        return pavilionWorksRepository.findAll(pageable);
    }


    public PavilionWorks findById(Long id) {
        return pavilionWorksRepository.getOne(id);
    }





    /**
     * @param file ��ý���ļ�
     * @return �ϴ��ļ�
     */
    @Transactional
    public Boolean upload(MultipartFile file, String tempDir, Long recordId) {
        String realDir = ConstantUtils.CONTEXT_PATH+"/upload/" + tempDir + "/";
        //��Ŀ��ý���ŵ��ļ��У�����ʱ�����Ψһ��ʶ��ʱ���ϴ������е��ļ�
        if (!UploadUtil.createDirectory(realDir)) {
            //Ŀ¼����ʧ���򷵻�null��Ŀ¼���ڻ��ߴ����ɹ��ͼ���ִ��
            return null;
        }
        String fileName = file.getOriginalFilename().replace(" ", "");//�ļ�����ȥ���ļ����еĿո�
        String filePath = realDir + "\\" + fileName;//�����ļ�·��
        boolean result = UploadUtil.uploadFile(file, filePath);//�ϴ��ļ���Tomcat����Ϊ��ʱ�ļ�;
        String relativePath = "/upload/" + tempDir + "/" + fileName;
        writeUploadLog(recordId, relativePath);
        return result;

    }


    /**
     * @param recordId ��¼id
     * @param filePath �ļ���·��
     */
    public void writeUploadLog(Long recordId, String filePath) {
        PavilionWorks pavilionWorks = pavilionWorksRepository.getOne(recordId);
        pavilionWorks.setPhotoUrl(filePath);
//        pavilionWorks.setHasPhoto(ConstantUtils.STATUS_YES);
        pavilionWorksRepository.save(pavilionWorks);
    }

}
