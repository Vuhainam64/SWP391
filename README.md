# SWP391

![FPT logo](https://github.com/Vuhainam64/SWP391/assets/87472661/a59e8385-2bf6-476d-a7b3-34d4e64e74b1)

# Software Requirement Specification
# Pet Store 

# Table of Contents
	*Quy trình 1: ( đăng kí tài khoản  khách hàng)

•	Cửa hàng gửi form cho khách hàng đăng kí

•	Sdt

•	Email

•	Mật khẩu

•	Nhập lại Mật khẩu

•	Tự động cấp roleid là user 

- Hệ thống duyệt thông tin và sau đó đăng nhập cho khách hàng ( Kiểm tra xem đã đúng định dạng và cơ sở dữ liệu đã cập nhật thành công chưa)
=> Hiên Popup đăng kí thành công và tự động đăng nhập cho khách hàng / nếu thất bại hiện popup nguyên nhân lỗi theo cách khách hàng hiểu vd: email không đúng định dạng,...

	*Quy trình 2: ( kiểm tra người dùng, login)

•	Lấy thông tin người dùng

•	Kiểm tra xem là admin manager hay user để cấp quyền cho người dùng

•	Nếu là user không có quyền tạo sp

•	Admin hoặc manager có quyền tạo sản phẩm thêm bớt xoá….(Chỉ có admin có quyền chỉnh sửa quyền manager….)

	*Quy trình 3: ( quản lý sản phẩm )

•	Đối với tài khoản của admin và nhân viên. Admin sẽ gửi thông tin những sản phầm và nhân viên sẽ cập nhật cửa hàng về:

•	Tên sản phẩm

•	Miêu tả sản phẩm

•	Giá cả

•	Chương trình giảm giá

•	Số lượng

•	Công thức thúc ăn

(Cả admin và nhân viên đều có quyền chỉnh sửa thông tin sản phẩm)

	*Quy trình 4 ( lấy chi tiết sản phẩm)

•	Cửa hàng gửi thông tin chi tiết sản phẩm cho khách hàng trong 1 trang web mới

•	Sản phẩm

•	Số lượng

•	Thông tin

•	Đánh giá

•	Add wishlist

	*Quy trình 5 ( quản lý cart)

•	Tạo giỏ hàng nếu giỏ hàng trống

•	Thêm vào giỏ hàng (detail to cart)

•	Sản phẩm

•	Số lượng

•	Xoá sản phẩm

•	Cập nhật giỏ hàng khi khách hàng điều chỉnh thêm bớt

•	Xoá toàn bộ giỏ hàng

•	Chuyển sang thanh toán

	*Quy trình 6 ( quản lý thanh toán )

•	Cửa hàng cho phép khách hàng chọn hình thức thanh toán bằng nhiều hình thức:

•	Trực tiếp: Thanh toán tại cửa hàng.

•	Gián tiếp: Thanh toán online qua app ngân hàng hoặc các app như MOMO,ZaloPay,..

•	Áp dụng mã giảm giá

•	Hủy hình thức thanh toán

•	Kiểm tra thanh toán thành công chưa do bên phía công ty chấp nhận thanh toán gửi về ( nếu thành công chuyển về trang chi tiết thanh toán và hiện popup thanh toán thành công tới khách hàng/ thất bại chuyển lại trang giỏ hàng và hiện popup thất bại)

	*Quy trình 7 ( Tạo sản phẩm mới, chỉnh sửa (kiểm tra user quy trình 2))

•	Tạo sản phẩm

•	Tên sp 

•	Hình ảnh

•	Category

•	Price

•	Chỉnh sửa sản phẩm

•	Lấy khoá sp

•	Chỉnh sửa tên hình ảnh

•	Chọn category (Select)

•	Price	…

•	Xoá sản phẩm 

•	Lấy khoá sp 

=> chỉ ẩn sản phẩm ko xoá vì dính khoá ngoại 

•	Kiểm tra xác nhận thay đổi hoặc xác nhận tạo mới, xoá


Note: Coupon 

•	Giảm giá lấy khoá từ product id

•	Kiểm tra xem product có chấp nhận sử dụng mã giảm giá hay ko

•	Mặc định khi tạo product thì product luôn chấp nhận giảm giá nếu ko chập nhận thì vào cài đặt sp r update lại

#Functional complexity analysis

![Functional complexity analysis](https://github.com/Vuhainam64/SWP391/assets/87472661/55614953-6c11-4662-9c00-1bd7acc3795c)


# Mô Hình EDR
![EDR](https://github.com/Vuhainam64/SWP391/assets/87472661/8e74aabf-aa9b-40ad-a933-ac4775051cda)

#Funtion Requirment 

	1. Welcome Page
	
![image](https://github.com/Vuhainam64/SWP391/assets/87472661/d042059c-3298-48f6-8748-5660a8c21e3a)

![Welcome Form](https://github.com/Vuhainam64/SWP391/assets/87472661/0333bce7-bc13-480e-9ddd-6a4b96c16082)

	2. Login Page
- Function trigger: when user provides correct information and clicks on login button.
- Function description:
+ Roles: include guests, students, mentors, and admin.
+ Purpose: confirm and authorise the user's information.
+ Data processing: process email and password of users.
- Function details: data that the user provides must be contained in the database. If the data is
not suitable, the system will notify an error.

![Login Form](https://github.com/Vuhainam64/SWP391/assets/87472661/56bf28a6-3329-47ea-bd3e-ae89a091a0d5)

	3. Shop
*View

![View](https://github.com/Vuhainam64/SWP391/assets/87472661/d048309d-bc2b-4e02-987e-39ae7cee2984)

*Category

![Category](https://github.com/Vuhainam64/SWP391/assets/87472661/faef6e0c-700f-42e7-ac7f-e51ff60d7cd4)

*Sort

![Sort](https://github.com/Vuhainam64/SWP391/assets/87472661/29440b47-e2d5-46b4-91bc-c7166e6103ed)

*Page Count

![Page Count](https://github.com/Vuhainam64/SWP391/assets/87472661/53b54b8c-cf5f-4291-bcda-8df68c6caf03)


	4. Detail
	
![image](https://github.com/Vuhainam64/SWP391/assets/87472661/4822832a-4588-45a3-9395-a287eab735f9)


	5. Cart

![image](https://github.com/Vuhainam64/SWP391/assets/87472661/85aa64a6-7ea2-43bb-8398-21f37c15a47f)

{@googleslide: https://docs.google.com/spreadsheets/d/1ag1gN8NNxO2CBG8T8pu5nh_WUw992iegwv0a8ylVtY8/edit#gid=0}


