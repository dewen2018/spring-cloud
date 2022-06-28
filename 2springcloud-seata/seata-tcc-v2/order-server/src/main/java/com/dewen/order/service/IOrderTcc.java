// package com.dewen.order.service;
//
// import io.seata.rm.tcc.api.BusinessActionContext;
// import io.seata.rm.tcc.api.BusinessActionContextParameter;
// import io.seata.rm.tcc.api.LocalTCC;
// import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
//
// @LocalTCC
// public interface IOrderTcc {
//
//     /**
//      * 定义两阶段提交
//      * name = 该tcc的bean名称,全局唯一
//      * commitMethod = commit 为二阶段确认方法
//      * rollbackMethod = rollback 为二阶段取消方法
//      * BusinessActionContextParameter注解 可传递参数到二阶段方法
//      *
//      * @param -入参
//      * @return String
//      */
//     @TwoPhaseBusinessAction(name = "orderTcc", commitMethod = "commit", rollbackMethod = "cancel")
//     void tryCreateOrder(@BusinessActionContextParameter(paramName = "orderId") String orderId,
//                         @BusinessActionContextParameter(paramName = "orderName") String orderName,
//                         @BusinessActionContextParameter(paramName = "productId") Long productId,
//                         @BusinessActionContextParameter(paramName = "count") Integer count);
//
//     /**
//      * context可以传递try方法的参数
//      *
//      * @param context 上下文
//      * @return boolean
//      */
//     boolean commit(BusinessActionContext context);
//
//     /**
//      * 二阶段取消方法
//      *
//      * @param context 上下文
//      * @return boolean
//      */
//     boolean cancel(BusinessActionContext context);
// }
