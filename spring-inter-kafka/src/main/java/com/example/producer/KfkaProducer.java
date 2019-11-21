package com.example.producer;import com.alibaba.fastjson.JSON;import com.example.bean.PersonEntity;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.kafka.core.KafkaTemplate;import org.springframework.stereotype.Component;/** * @author 朱朝阳 * kafka生产者 * @date 2019/11/21 20:15 */@Component@Slf4jpublic class KfkaProducer {    @Autowired    private KafkaTemplate<String, String> kafkaTemplate;    //发送消息方法    public void sendToLocalKafkaServer() {        for (int i = 0; i < 5; i++) {            PersonEntity personEntity = PersonEntity.builder().id(Long.valueOf(i)).name("朱朝阳" + i).gender(i % 2 == 0 ? true : false)                    .height(Math.random() * 100).build();            log.info("发送消息 ----->>>>>  message = {}", JSON.toJSONString(personEntity));            kafkaTemplate.send("hello", JSON.toJSONString(personEntity));        }    }}