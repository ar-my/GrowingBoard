package com.jenson.board;

import com.jenson.board.entity.jpa.Notice;
import com.jenson.board.repository.jpa.NoticeRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardJpaTest {

    @Autowired
    private NoticeRepository noticeRepository;

    private Notice generatorUser() {
        return new Notice("whoami", "coffe", "jenson.lee");
    }

    @Test // MYSQL ENGINE 에 따라 롤백이 동작하지 않을 수도 있음
    public void notice_save_test() {
        Notice notice = generatorUser();
        Notice saveNotice = this.noticeRepository.save(notice);
        System.out.println("saved = " + noticeRepository.count());
        assertThat(saveNotice.getId(), is(notNullValue()));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void notice_title_null_save_test() {
        Notice notice = new Notice();
        notice.setContent("coffe");
        notice.setUserId("jenson.lee");
        this.noticeRepository.save(notice);
    }

    @Ignore
    @Test
    public void sort_test() {
        Sort sort = new Sort(Sort.Direction.DESC, "title")
                .and(new Sort(Sort.Direction.ASC, "userId"));

        Iterable<Notice> notices = this.noticeRepository.findAll(sort);
        notices.forEach(System.out::println);
    }
}

