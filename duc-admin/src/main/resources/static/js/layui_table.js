//定义处理数据结构转化的适配器
var parseDataFun = function (result){
    return {
        "code": 0
        , "message": result.msg
        , "data": result.data.list
        , "count": result.data.total
    };
};