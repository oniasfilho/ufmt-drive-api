package io.oniasfilho.ufmtdrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteReqDTO {
    private String note_title;
    private String note_description;
    private Long user_id;
}
