package io.oniasfilho.ufmtdrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteReqForUpdateDTO {
    private Long note_id;
    private String note_title;
    private String note_description;
}
