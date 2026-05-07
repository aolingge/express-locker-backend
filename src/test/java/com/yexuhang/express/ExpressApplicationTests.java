package com.yexuhang.express;

import com.yexuhang.express.config.CommonResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressApplicationTests {

    @Test
    void commonResultSuccessWrapsData() {
        CommonResult<String> result = CommonResult.success("ok");

        assertEquals(200, result.getCode());
        assertEquals("操作成功", result.getMsg());
        assertEquals("ok", result.getData());
    }

}
