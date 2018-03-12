package com.subway.memberWorks;

import java.util.List;
import java.util.Map;

import com.subway.columnsContent.ColumnsContent;
import com.subway.member.Member;
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
 * 会员作品涓氬姟绫?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Service
public class MemberWorksService extends BaseService {


    @Autowired
    MemberWorksRepository memberWorksRepository;

    @Autowired
    CommonDataService commonDataService;

    /**
     * @return
     */
    public List<MemberWorks> findAll() {
        return memberWorksRepository.findAll();
    }


    /**
     * @param pageable
     * @return
     */
    public Page<MemberWorks> findAll(Pageable pageable) {
        return memberWorksRepository.findAll(pageable);
    }


    /**
     * @param id
     * @return
     */
    public MemberWorks findById(Long id) {
        return memberWorksRepository.getOne(id);
    }


    /**
     * @param id 记录id
     * @return 根据id删除记录
     */
    public ReturnObject delete(Long id) {
        memberWorksRepository.delete(id);
        MemberWorks memberWorks = memberWorksRepository.getOne(id);
        return commonDataService.getReturnType(memberWorks == null, "记录删除成功", "记录删除失败");
    }


    /**
     * @param file 多媒体文件
     * @return 上传文件
     */
    @Transactional
    public Boolean upload(MultipartFile file, String tempDir, Long recordId) {
        String realDir = ConstantUtils.CONTEXT_PATH + "/upload/" + tempDir + "/";//项目多媒体存放的文件夹，加上时间戳来唯一标识该时间上传的所有的文件
        if (!UploadUtil.createDirectory(realDir)) {//目录创建失败则返回null，目录存在或者创建成功就继续执行
            return null;
        }
        String fileName = file.getOriginalFilename().replace(" ", "");//文件名，去掉文件名中的空格
        String filePath = realDir + "\\" + fileName;//绝对文件路径
        boolean result = UploadUtil.uploadFile(file, filePath);//上传文件到Tomcat，作为临时文件;
        String relativePath = "upload/" + tempDir + "/" + fileName;
        writeUploadLog(relativePath, recordId);
        return result;

    }


    /**
     * @param recordId 记录id
     * @param filePath 文件的路径
     */
    public void writeUploadLog(String filePath, Long recordId) {
        MemberWorks memberWorks = memberWorksRepository.getOne(recordId);
        memberWorks.setPhotoUrl(filePath);
        memberWorksRepository.save(memberWorks);
    }
}
