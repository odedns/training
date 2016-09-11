#
# Cookbook Name:: test1
# Recipe:: default
#
# Copyright (c) 2016 The Authors, All Rights Reserved.


tomcat_home  = "/var/lib/tomcat7"
webapps = "#{tomcat_home}/webapps"

Chef::Log.info("installing jre...")
package  'openjdk-7-jre' do
  action :install
end


# put chefed in the group so we can make sure we don't remove it by managing cool_group
group 'tomcat' do
  members 'tomcat'
  action :create
end

Chef::Log.info("installing tomcat...")
package 'tomcat7' do
  action :install
end

service 'tomcat7' do
  action :start
end

directory "#{webapps}" do
  owner 'tomcat'
  group 'tomcat'
  mode '0755'
  action :create
end

Chef::Log.info("webapps dir = #{webapps}")
war_file = "#{webapps}/petclinic.war"
remote_file "#{war_file}" do
  source 'http://10.0.2.2:8080/job/petclinic_github/lastSuccessfulBuild/org.springframework.samples$petclinic_sdk/artifact/org.springframework.samples/petclinic_sdk/1.0.0-SNAPSHOT/petclinic_sdk-1.0.0-SNAPSHOT.war'
  owner 'tomcat'
  group 'tomcat'
  mode '0755'
  action :create
end
Chef::Log.info("recipe done....")
