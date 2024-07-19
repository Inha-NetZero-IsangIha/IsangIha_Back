
// IsangihaApplicationTests.java
package com.isangiha.isangiha;

import com.isangiha.isangiha.domain.Container;
import com.isangiha.isangiha.domain.Coordinate;
import com.isangiha.isangiha.domain.Event;
import com.isangiha.isangiha.repository.ContainerRepository;
import com.isangiha.isangiha.repository.CoordinateRepository;
import com.isangiha.isangiha.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IsangihaApplicationTests {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CoordinateRepository coordinateRepository;

    @Autowired
    private ContainerRepository containerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void createAndSaveEventsWithCoordinates() {
        // 인하대 축제 이벤트 생성 및 저장
        Event inhaEvent = new Event();
        inhaEvent.setEnterpriseName("Example Enterprise2");
        inhaEvent.setEventName("인하대 축제");
        inhaEvent.setHeadcount(150);
        inhaEvent.setStartDate("2024-07-19");
        inhaEvent.setEndDate("2024-07-22");
        inhaEvent.setDeliveryDate("2024-07-18");
        inhaEvent.setCollectionDate("2024-07-23");
        inhaEvent.setLocation("Convention Center");
        inhaEvent.setCluster("1");  // Integer에서 String으로 변경
        inhaEvent.setMeeting("true");  // boolean에서 String으로 변경
        inhaEvent.setMeetingDate("2024-07-21");

        final Event savedInhaEvent = eventRepository.save(inhaEvent);

        // 인하대 축제 좌표 생성 및 저장
        List<Coordinate> inhaCoordinates = List.of(
                new Coordinate("37.451345", "126.651524", "인하대 스팟 1"),
                new Coordinate("37.4507834", "126.6541873", "인하대 스팟 2"),
                new Coordinate("37.4491516", "126.6523529", "인하대 스팟 3")
        );

        inhaCoordinates.forEach(coordinate -> {
            coordinate.setEvent(savedInhaEvent);
            coordinateRepository.save(coordinate);
        });

        // 인하대 축제 컨테이너 생성 및 저장
        Container inhaContainer = new Container();
        inhaContainer.setEvent(savedInhaEvent);
        inhaContainer.setContainerType("standard");
        inhaContainer.setQuantity(2);
        containerRepository.save(inhaContainer);

        // 영등포 한강 축제 이벤트 생성 및 저장
        Event yeouidoEvent = new Event();
        yeouidoEvent.setEnterpriseName("Example Enterprise2");
        yeouidoEvent.setEventName("영등포 한강 축제");
        yeouidoEvent.setHeadcount(150);
        yeouidoEvent.setStartDate("2024-07-19");
        yeouidoEvent.setEndDate("2024-07-22");
        yeouidoEvent.setDeliveryDate("2024-07-18");
        yeouidoEvent.setCollectionDate("2024-07-23");
        yeouidoEvent.setLocation("Convention Center");
        yeouidoEvent.setCluster("1");  // Integer에서 String으로 변경
        yeouidoEvent.setMeeting("true");  // boolean에서 String으로 변경
        yeouidoEvent.setMeetingDate("2024-07-21");

        final Event savedYeouidoEvent = eventRepository.save(yeouidoEvent);

        // 영등포 한강 축제 좌표 생성 및 저장
        List<Coordinate> yeouidoCoordinates = List.of(
                new Coordinate("37.5223245", "126.9101692", "여의도 한강 스팟 1"),
                new Coordinate("37.522735", "126.905056", "여의도 한강 스팟 2"),
                new Coordinate("37.5223245", "126.9101692", "여의도 한강 스팟 3")
        );

        yeouidoCoordinates.forEach(coordinate -> {
            coordinate.setEvent(savedYeouidoEvent);
            coordinateRepository.save(coordinate);
        });

        // 영등포 한강 축제 컨테이너 생성 및 저장
        Container yeouidoContainer = new Container();
        yeouidoContainer.setEvent(savedYeouidoEvent);
        yeouidoContainer.setContainerType("standard");
        yeouidoContainer.setQuantity(2);
        containerRepository.save(yeouidoContainer);
    }
}