package umc.spring.repository.MissionHistoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.mapping.MissionHistory;

import java.util.List;

public interface MissionHistoryRepository extends JpaRepository<MissionHistory, Long> {

    @Query("select mh from MissionHistory mh where mh.member.id = :memberId")
    List<MissionHistory> findAllByMemberId(@Param("memberId") Long memberId);

    @Query("select mh from MissionHistory mh where mh.mission.id = :missionId")
    List<MissionHistory> findAllByMissionId(@Param("missionId") Long missionId);
}
