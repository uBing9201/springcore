package com.study.springcore.score.repository;

import com.study.springcore.score.entity.Grade;
import com.study.springcore.score.entity.Score;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository // @Component랑 같이 빈등록 하겠다는 어노테이션, 이름으로 좀더 클래스 역할을 명확하게 표시
@RequiredArgsConstructor // 파이널 변수 초기화 전용 생성자.
public class ScoreRepositoryImpl implements ScoreRepository {

    class ScoreMapper implements RowMapper<Score> {

        // ResultSet은 sql의 실행 결과를 들고 있다.
        // 타겟을 한 행씩 지목하면서 컬럼값을 가져올 수 있다.
        // 한 행의 데이터를 어떤 객체로 어떻게 포장할 것인지는 직접 입력
        @Override
        public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
            // sql 로 조회는 해왔지만 어찌 포장하는지 몰르기에
            // 그걸 mapRow 메서드로 알려주는방식 -> 한 행마다 이렇게 포장해서 리턴
            return new Score(
                    rs.getInt("stu_num"),
                    rs.getString("stu_name"),
                    rs.getInt("kor"),
                    rs.getInt("eng"),
                    rs.getInt("math"),
                    rs.getInt("total"),
                    rs.getDouble("average"),
                    Grade.valueOf(rs.getString("grade"))
            );
        }
    }

    // Spring-jdbc의 핵심 객체. -> 의존성 객체 주이브로 받아와서 사용.
    // 데이터베이스 접속 객체(Connection)을 바로 활용하는 것이 가능 -> 미리 세팅 다 해놓음.
    private final JdbcTemplate template;

    @Override
    public void save(Score score) {
        String sql = "INSERT INTO scores " +
                "(stu_name, kor, eng, math, total, average, grade) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, score.getStuName(), score.getKor(), score.getEng(),
                        score.getMath(), score.getTotal(), score.getAverage(), score.getGrade().toString());
    }

    @Override
    public List<Score> selectAll() {
        String sql = "SELECT * FROM scores";

        // query: 여러 행을 조회해야 할 때 사용, 매개값으로 sql과 RowMapper의 구현체 전달.
        // JdbcTemplate은 ScoreMapper에 있는 MapRow 메서드를 통해 한행씩 객체를 포장.

//        List<Score> scoreList = template.query(sql, new ScoreMapper());
//        return scoreList;

        return template.query(sql, new ScoreMapper());
    }

    @Override
    public Score selectOne(int stuNum) {
        String sql = "SELECT * FROM scores WHERE stu_num = ?";
        // 한 행 조회시에는 queryForObject를 사용한다.
        // 조회된 결과를 포장하는 것은 동일하기 때문에 ScoreMapper를 재활용
//        Score score = template.queryForObject(sql, new ScoreMapper(), stuNum);
//        return score;

        return template.queryForObject(sql, new ScoreMapper(), stuNum);
    }

    @Override
    public void delete(int stuNum) {
        String sql = "DELETE FROM scores WHERE stu_num = ?";
        template.update(sql, stuNum);
    }
}
