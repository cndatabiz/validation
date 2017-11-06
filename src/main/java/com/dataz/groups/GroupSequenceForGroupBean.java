package com.dataz.groups;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, GroupName.class, GroupAddress.class})
public interface GroupSequenceForGroupBean {

}
