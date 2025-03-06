package siat.study.post.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import siat.study.post.domain.PostRequestDTO;
import siat.study.post.domain.PostResponseDTO;

// xxxDAO(Data Access Object)로 DBMS와 작업을 전담하는 역할
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PostDAO {

    public PostRequestDTO[] requestAry ;
    private int idx ;

    public void insertRow(PostRequestDTO request) {
        requestAry[idx++] = request ;
    }

    public PostRequestDTO[] selectRow() {
        return requestAry ;

    }

}
