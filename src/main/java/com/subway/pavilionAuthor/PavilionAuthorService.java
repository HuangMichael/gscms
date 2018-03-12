package com.subway.pavilionAuthor;

import java.util.List;
import java.util.Map;

import com.subway.member.Member;
import com.subway.memberWorks.MemberWorks;
import com.subway.object.ReturnObject;
import com.subway.service.app.BaseService;
import com.subway.service.commonData.CommonDataService;
import com.subway.utils.ConstantUtils;
import com.subway.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * 展馆作者信息业务类
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class PavilionAuthorService extends BaseService {


    @Autowired
    PavilionAuthorRepository pavilionAuthorRepository;


    @Autowired
    CommonDataService commonDataService;

    /**
     * @return
     */
    public List<PavilionAuthor> findAll() {
        return pavilionAuthorRepository.findAll();
    }


    /**
     * @param pageable
     * @return
     */
    public Page<PavilionAuthor> findAll(Pageable pageable) {
        return pavilionAuthorRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return
     */
    public PavilionAuthor findById(Long id) {
        return pavilionAuthorRepository.getOne(id);
    }


    /**
     * @param id 记录id
     * @return 根据id删除记录
     */
    public ReturnObject delete(Long id) {
        pavilionAuthorRepository.delete(id);
        PavilionAuthor pavilionAuthor = pavilionAuthorRepository.getOne(id);
        return commonDataService.getReturnType(pavilionAuthor == null, "记录删除成功", "记录删除失败");
    }


    /**
     * @param file 多媒体文件
     * @return 上传文件
     */
    @Transactional
    public Boolean upload(MultipartFile file, String tempDir, Long recordId) {
        String realDir = ConstantUtils.CONTEXT_PATH + "/upload/" + tempDir + "/";
        //项目多媒体存放的文件夹，加上时间戳来唯一标识该时间上传的所有的文件
        if (!UploadUtil.createDirectory(realDir)) {
            //目录创建失败则返回null，目录存在或者创建成功就继续执行
            return null;
        }
        String fileName = file.getOriginalFilename().replace(" ", "");//文件名，去掉文件名中的空格
        String filePath = realDir + "\\" + fileName;//绝对文件路径
        boolean result = UploadUtil.uploadFile(file, filePath);//上传文件到Tomcat，作为临时文件;
        String relativePath = "/upload/" + tempDir + "/" + fileName;
        writeUploadLog(recordId, relativePath);
        return result;

    }


    /**
     * @param recordId 记录id
     * @param filePath 文件的路径
     */
    public void writeUploadLog(Long recordId, String filePath) {
        PavilionAuthor pavilionAuthor = pavilionAuthorRepository.getOne(recordId);
        pavilionAuthor.setPhotoUrl(filePath);
        pavilionAuthor.setHasPhoto(ConstantUtils.STATUS_YES);
        pavilionAuthorRepository.save(pavilionAuthor);
    }

}
