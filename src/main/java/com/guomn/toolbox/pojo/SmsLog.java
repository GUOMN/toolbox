package com.guomn.toolbox.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SmsLog {
    private Long id;
    private Long toMobile;
    private String logContant;
    private Byte sendStatus;

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsLog)) return false;
        SmsLog smsLog = (SmsLog) o;
        return Objects.equals(getId(), smsLog.getId()) &&
                Objects.equals(getToMobile(), smsLog.getToMobile()) &&
                Objects.equals(getLogContant(), smsLog.getLogContant()) &&
                Objects.equals(getSendStatus(), smsLog.getSendStatus());
    }

    @Override
        public int hashCode() {

        return Objects.hash(getId(), getToMobile(), getLogContant(), getSendStatus());
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getToMobile() {
        return toMobile;
    }

    public void setToMobile(Long toMobile) {
        this.toMobile = toMobile;
    }

    public String getLogContant() {
        return logContant;
    }

    public void setLogContant(String logContant) {
        this.logContant = logContant;
    }

    public Byte getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
    }
}
