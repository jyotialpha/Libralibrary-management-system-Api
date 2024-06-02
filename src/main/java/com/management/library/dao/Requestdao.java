package com.management.library.dao;

import java.util.List;

import com.management.library.model.History;
import com.management.library.model.HistoryCountModel;
import com.management.library.model.HistoryCountReturn;
import com.management.library.model.Request;

public interface Requestdao {

	int add(Request requestEntity);
  //List<Request> findPendingRequests();
    List<Request> findAllRequests();
  //Request findById(Long requestId);
    List<History> findAllHistory();
    //public HistoryCountReturn RequestforbookApproval(HistoryCountModel hcm);
   // int updateApprovalStatus(int requestId, boolean approved);
   
    public HistoryCountReturn gettotalBookQuantity(HistoryCountModel hcm) ;
  //  public String ccompare(Request rr);
}
