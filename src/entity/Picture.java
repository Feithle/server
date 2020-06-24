package entity;

public class Picture {
    public int pic_id;
    public String pic_name;
    public String title;
    public String category;
    public String copyright;
    public String nature;
    public String culture;
    public String life;
    public String comrecom;
    public String sysrecom;
    public String source;
    public String path_pic;
    public String country;
    public String province;
    public String city;
    public String depart;
    public String street;
    public String description;
    public String username;
    public String useremail;
    public String phone;
    public double rate;
    public String lastuse;
    public int available;
    public String uptime;
    public int user_id;

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getComrecom() {
        return comrecom;
    }

    public void setComrecom(String comrecom) {
        this.comrecom = comrecom;
    }

    public String getSysrecom() {
        return sysrecom;
    }

    public void setSysrecom(String sysrecom) {
        this.sysrecom = sysrecom;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPath_pic() {
        return path_pic;
    }

    public void setPath_pic(String path_pic) {
        this.path_pic = path_pic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getLastuse() {
        return lastuse;
    }

    public void setLastuse(String lastuse) {
        this.lastuse = lastuse;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pic_id=" + pic_id +
                ", pic_name='" + pic_name + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", copyright='" + copyright + '\'' +
                ", nature='" + nature + '\'' +
                ", culture='" + culture + '\'' +
                ", life='" + life + '\'' +
                ", comrecom='" + comrecom + '\'' +
                ", sysrecom='" + sysrecom + '\'' +
                ", source='" + source + '\'' +
                ", path_pic='" + path_pic + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", depart='" + depart + '\'' +
                ", street='" + street + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", phone='" + phone + '\'' +
                ", rate=" + rate +
                ", lastuse='" + lastuse + '\'' +
                ", available=" + available +
                ", uptime='" + uptime + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}

