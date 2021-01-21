export hub_name='selenium_hub'
export browser_name='selenium_chrome'
export currentBrowser='docker'

# 清理当前 Docker 环境
docker rm -f $hub_name $browser_name

# 启动 docker container
docker run -p 5555:4444 -d --name $hub_name selenium/hub:3.7.1-beryllium
docker run -P -d --name $browser_name --link $hub_name:hub  selenium/node-chrome-debug:3.7.1-beryllium

# 运行自动测试
mvn clean install

# 清理 docker 环境
docker rm -f $hub_name $browser_name