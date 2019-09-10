package com.jenson.board.docs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jenson.board.controller.RestBoardController;
import com.jenson.board.entity.jpa.Notice;
import com.jenson.board.service.BoardService;
import com.jenson.board.service.NoticeBoardService;
import com.jenson.board.service.RecentlyNoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static com.jenson.board.docs.ApiDocumentUtils.getDocumentRequest;
import static com.jenson.board.docs.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestBoardController.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com")
@MockBean(JpaMetamodelMappingContext.class)
public class NoticeDocumentTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private NoticeBoardService noticeBoardService;

    @MockBean
    private RecentlyNoticeService recentlyNoticeService;

    @Test
    public void findAll() throws Exception {

        //given
        List<Notice> responseList = Arrays.asList(
            new Notice(
                    1L,
                    "music",
                    "duruduru",
                    "jenson.lee"),
            new Notice(
                    2L,
                    "game",
                    "lol",
                    "manyreason")
        );

        given(noticeBoardService.findAll()).willReturn(responseList);

        //when
        ResultActions result = this.mockMvc.perform(
                get("/v1/board/notices")
                    .accept(MediaType.APPLICATION_JSON)
        );

        //then
        result.andExpect(status().isOk())
                .andDo(document("notices-find-all",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        responseFields(
//                                beneathPath("data").withSubsectionId("data"),
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("아이디"),
                                fieldWithPath("[].title").type(JsonFieldType.STRING).description("제목"),
                                fieldWithPath("[].content").type(JsonFieldType.STRING).description("내용"),
                                fieldWithPath("[].userId").type(JsonFieldType.STRING).description("유저아이디"),
                                fieldWithPath("[].createAt").type(JsonFieldType.NULL).description("등록일"),
                                fieldWithPath("[].updateAt").type(JsonFieldType.NULL).description("수정일")
                        )
                ));
    }

}
