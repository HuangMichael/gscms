package com.subway.message;

import lombok.Data;

import javax.persistence.*;

/**
* ���Թ�����Ϣ
*/
@Entity
@Table(name = "t_message")
@Data
public class Message {

private String id;
private String content;

}
