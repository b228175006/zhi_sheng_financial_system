/**
 * 登录页面
 * Created by bili on 2017/6/18.
 */
import React from 'react';
import { Form, Icon, Input, Button,Layout,message} from 'antd';
const { Header, Content, Sider ,Footer} = Layout;
const FormItem = Form.Item;
class PCLogin extends React.Component{
    constructor(){
        super();
        if(localStorage.userId){
            location.href="/#/main/index";
        }
    }
    handleSubmit(e){
        var data = this.props.form.getFieldsValue();
        var myFetchOptions = {
            method: 'POST',
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: "userName="+data.userName+"&password="+data.password
        };
        fetch("/login/in", myFetchOptions).then(response => response.json()).then(json => {
            if(json.status == 'success'){
                localStorage.setItem('userNikeName',json.data.userNikeName);
                localStorage.setItem('userId',json.data.userId);
                message.success(json.msg);
               location.href="/#/main/index";
            }else{
                message.error(json.msg);
            }
        });
        // localStorage.setItem('userNikeName',"admin");
        // localStorage.setItem('userId',"123");
        // message.success("success");
        // location.href="/#/main/index";
    }
    render(){
        const { getFieldDecorator } = this.props.form;
        return(
            <div className="login-main">
                <Form onSubmit={this.handleSubmit.bind(this)} className="login-form">
                    <div className="logo"></div>
                    <FormItem>
                        {getFieldDecorator('userName', {
                            rules: [{ required: true, message: '请输入您的用户名！' }],
                        })(
                            <Input prefix={<Icon type="user" style={{ fontSize: 13 }} />} placeholder="用户名" />
                        )}
                    </FormItem>
                    <FormItem>
                        {getFieldDecorator('password', {
                            rules: [{ required: true, message: '请输入您的密码！'}],
                        })(
                            <Input prefix={<Icon type="lock" style={{ fontSize: 13 }} />} type="password" placeholder="密码" />
                        )}
                    </FormItem>
                    <FormItem>
                        <Button type="primary" htmlType="submit" className="login-form-button">
                            Log in
                        </Button>
                    </FormItem>
                </Form>
            </div>
        )
    }
}
export default PCLogin = Form.create()(PCLogin);