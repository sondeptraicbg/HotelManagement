USE [myHotel]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[InvoiceID] [bigint] NOT NULL,
	[BookingID] [bigint] NULL,
	[GuestID] [bigint] NULL,
	[RoomCharge] [int] NULL,
	[PaymentDate] [date] NULL,
	[PaymentMode] [nvarchar](10) NULL,
	[ExpireDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[InvoiceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Booking]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking](
	[BookingID] [bigint] NOT NULL,
	[HotelCode] [int] NULL,
	[GuestID] [bigint] NULL,
	[BookingDate] [date] NULL,
	[SpecialReq] [text] NULL,
	[RoomID] [int] NOT NULL,
	[quantity] [int] NULL,
	[endDate] [date] NULL,
	[Price] [int] NULL,
	[Type] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[BookingID] ASC,
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[HotelCode] [int] NOT NULL,
	[GuestID] [bigint] NOT NULL,
	[Comment] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[HotelCode] ASC,
	[GuestID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[ID] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Email] [nvarchar](25) NULL,
	[Content] [text] NULL,
	[Status] [bit] NULL,
	[Feedbak] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employees]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employees](
	[EmoloyeeID] [int] NOT NULL,
	[HotelCode] [int] NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](20) NULL,
	[Gender] [nvarchar](10) NULL,
	[DateOfBirth] [date] NULL,
	[Email] [nvarchar](20) NULL,
	[Salary] [int] NULL,
	[Role] [nvarchar](20) NULL,
	[Password] [nvarchar](10) NOT NULL,
	[Phone] [bigint] NULL,
	[RoleDesc] [text] NULL,
	[Status] [nvarchar](25) NULL,
PRIMARY KEY CLUSTERED 
(
	[EmoloyeeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Guest]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Guest](
	[GuestID] [bigint] NOT NULL,
	[FirstName] [nvarchar](20) NULL,
	[LastName] [nvarchar](10) NULL,
	[DateOfBirth] [date] NULL,
	[Phone] [bigint] NULL,
	[Gender] [nvarchar](8) NULL,
	[Email] [nvarchar](30) NULL,
	[Password] [nvarchar](10) NOT NULL,
	[Address] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[GuestID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hotel]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hotel](
	[HotelCode] [int] NOT NULL,
	[HotelName] [nvarchar](50) NULL,
	[Location] [nvarchar](50) NULL,
	[NumRooms] [int] NULL,
	[City] [nvarchar](20) NULL,
	[Phone] [bigint] NULL,
	[StarRating] [float] NULL,
	[Img] [nvarchar](20) NULL,
	[Map] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[HotelCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[RoomID] [int] NOT NULL,
	[RoomType] [nvarchar](20) NULL,
	[HotelCode] [int] NULL,
	[RoomPrice] [int] NULL,
	[RoomImg] [nvarchar](30) NULL,
	[RoomDesc] [text] NULL,
	[Area] [int] NULL,
	[Bed] [nvarchar](20) NULL,
	[Direct] [nvarchar](10) NULL,
	[Available] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service]    Script Date: 11/8/2022 2:01:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[ServiceCode] [int] NOT NULL,
	[HotelCode] [int] NULL,
	[ServiceName] [nvarchar](50) NULL,
	[StarRating] [float] NULL,
	[ServiceImg] [nvarchar](20) NULL,
	[ServiceDes] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[ServiceCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (1, 1, 1010101, 100, CAST(N'2022-01-01' AS Date), N'viettel', CAST(N'2022-01-04' AS Date))
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (2, 2, 12323232, 67, CAST(N'2022-08-01' AS Date), N'mobile', CAST(N'2022-08-04' AS Date))
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (3, 3, 12323232, 78, CAST(N'2022-09-01' AS Date), N'paypal', CAST(N'2022-09-04' AS Date))
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (4, 4, 2312313113, 120, CAST(N'2022-07-01' AS Date), N'paypal', CAST(N'2022-07-04' AS Date))
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (5, 5, 2312313113, 90, CAST(N'2022-01-04' AS Date), N'visa', CAST(N'2022-01-06' AS Date))
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (6, 1, 1010101, 200, CAST(N'2022-01-01' AS Date), N'viettel', CAST(N'2022-01-04' AS Date))
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (7, 7, 1010101, 200, CAST(N'2022-01-01' AS Date), N'viettel', CAST(N'2022-01-04' AS Date))
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (101020221031, 101020221031, 1010101, 50, CAST(N'2022-10-31' AS Date), N'Bank', CAST(N'2022-10-05' AS Date))
INSERT [dbo].[Bill] ([InvoiceID], [BookingID], [GuestID], [RoomCharge], [PaymentDate], [PaymentMode], [ExpireDate]) VALUES (101020221101, 101020221101, 1010101, 296, CAST(N'2022-11-01' AS Date), N'Bank', CAST(N'2022-11-04' AS Date))
GO
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1, 30001, 1010101, CAST(N'2022-01-01' AS Date), N'no', 301101, 1, CAST(N'2022-10-10' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1, 30001, 1010101, CAST(N'2022-07-01' AS Date), N'no', 301201, 1, CAST(N'2022-10-10' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2, 30002, 1010101, CAST(N'2022-01-01' AS Date), N'no', 301101, 1, CAST(N'2022-10-10' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (3, 30002, 1010101, CAST(N'2022-08-01' AS Date), N'no', 301201, 1, CAST(N'2022-10-10' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (4, 30001, 1010101, CAST(N'2022-09-01' AS Date), N'no', 301101, 1, CAST(N'2022-10-10' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5, 30001, 1010101, CAST(N'2022-07-01' AS Date), N'no', 301501, 1, CAST(N'2022-10-10' AS Date), 90, N'Deluxe room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (3423242, 30001, 1010101, CAST(N'2022-09-01' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (24232142, 30001, 1010101, CAST(N'2022-09-14' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (34232142, 30001, 1010101, CAST(N'2022-09-04' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (34234242, 30001, 1010101, CAST(N'2022-07-01' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (114343312, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (242455142, 30001, 1010101, CAST(N'2022-09-12' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (242455452, 30001, 1010101, CAST(N'2022-09-12' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (342384242, 30001, 1010101, CAST(N'2022-08-01' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1135274132, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301201, 1, CAST(N'2022-09-14' AS Date), 70, N'Double Room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1152156812, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301101, 1, CAST(N'2022-01-04' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1152232351, 30001, 1010101, CAST(N'2022-03-11' AS Date), N'no', 301501, 1, CAST(N'2022-01-04' AS Date), 90, N'Deluxe room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1152324812, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301101, 1, CAST(N'2022-01-04' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1152786812, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301101, 1, CAST(N'2022-01-04' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1153412351, 30001, 1010101, CAST(N'2022-03-11' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1153417851, 30001, 1010101, CAST(N'2022-10-11' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1153432351, 30001, 1010101, CAST(N'2022-03-11' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1154612312, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1154623312, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (1154664812, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301101, 1, CAST(N'2022-01-04' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2412454521, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2412454527, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2412454527, 30001, 1010101, CAST(N'2022-07-12' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2412454567, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301101, 1, CAST(N'2022-01-04' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2424554521, 30001, 1010101, CAST(N'2022-08-12' AS Date), N'no', 301401, 1, CAST(N'2022-01-04' AS Date), 80, N'Standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2434454527, 30001, 1010101, CAST(N'2022-07-12' AS Date), N'no', 301401, 1, CAST(N'2022-01-04' AS Date), 80, N'Standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2434554521, 30001, 1010101, CAST(N'2022-08-12' AS Date), N'no', 301501, 1, CAST(N'2022-01-04' AS Date), 90, N'Deluxe room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2434554522, 30001, 1010101, CAST(N'2022-08-12' AS Date), N'no', 301501, 1, CAST(N'2022-01-04' AS Date), 90, N'Deluxe room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2434554523, 30001, 1010101, CAST(N'2022-08-12' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2434554524, 30001, 1010101, CAST(N'2022-08-12' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2434554525, 30001, 1010101, CAST(N'2022-08-12' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (2434554527, 30001, 1010101, CAST(N'2022-07-12' AS Date), N'no', 301301, 1, CAST(N'2022-01-04' AS Date), 76, N'Double Room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5412454521, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301301, 1, CAST(N'2022-01-04' AS Date), 76, N'Double Room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5412454523, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301401, 1, CAST(N'2022-01-04' AS Date), 80, N'Standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5412454545, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301501, 1, CAST(N'2022-01-04' AS Date), 90, N'Deluxe room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5422454545, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5422575611, 30001, 1010101, CAST(N'2022-05-11' AS Date), N'no', 301401, 1, CAST(N'2022-01-04' AS Date), 80, N'Standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5423454144, 30001, 1010101, CAST(N'2022-05-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5423454154, 30001, 1010101, CAST(N'2022-05-11' AS Date), N'no', 301401, 1, CAST(N'2022-01-04' AS Date), 80, N'Standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5423454155, 30001, 1010101, CAST(N'2022-05-11' AS Date), N'no', 301501, 1, CAST(N'2022-01-04' AS Date), 90, N'Deluxe room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5423454544, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5423454545, 30001, 1010101, CAST(N'2022-06-12' AS Date), N'no', 301101, 1, CAST(N'2022-01-04' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5423474155, 30001, 1010101, CAST(N'2022-05-11' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5423475611, 30001, 1010101, CAST(N'2022-05-11' AS Date), N'no', 301301, 1, CAST(N'2022-01-04' AS Date), 76, N'Double Room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (5423475655, 30001, 1010101, CAST(N'2022-05-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11134134132, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11165674132, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11324274132, 30001, 1010101, CAST(N'2022-09-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11522335551, 30001, 1010101, CAST(N'2022-03-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11522335611, 30001, 1010101, CAST(N'2022-03-11' AS Date), N'no', 301101, 1, CAST(N'2022-01-04' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11522377551, 30001, 1010101, CAST(N'2022-03-11' AS Date), N'no', 301401, 1, CAST(N'2022-01-04' AS Date), 80, N'Standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11523335611, 30001, 1010101, CAST(N'2022-04-11' AS Date), N'no', 301101, 1, CAST(N'2022-01-04' AS Date), 60, N'standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11523575611, 30001, 1010101, CAST(N'2022-04-11' AS Date), N'no', 301301, 1, CAST(N'2022-01-04' AS Date), 76, N'Double Room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (11534156851, 30001, 1010101, CAST(N'2022-10-11' AS Date), N'no', 301601, 1, CAST(N'2022-01-04' AS Date), 96, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (54223575611, 30001, 1010101, CAST(N'2022-04-11' AS Date), N'no', 301401, 1, CAST(N'2022-01-04' AS Date), 80, N'Standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (101020221031, 30001, 1010101, CAST(N'2022-10-04' AS Date), N'ss', 301201, 1, CAST(N'2022-10-05' AS Date), 50, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (101020221101, 30001, 1010101, CAST(N'2022-11-02' AS Date), N'no', 301301, 1, CAST(N'2022-11-04' AS Date), 76, N'Double Room')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (101020221101, 30001, 1010101, CAST(N'2022-11-02' AS Date), N'no', 301401, 2, CAST(N'2022-11-04' AS Date), 80, N'Standard')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (101020221101, 30002, 1010101, CAST(N'2022-11-02' AS Date), N'no', 302101, 1, CAST(N'2022-11-04' AS Date), 60, N'VIP')
INSERT [dbo].[Booking] ([BookingID], [HotelCode], [GuestID], [BookingDate], [SpecialReq], [RoomID], [quantity], [endDate], [Price], [Type]) VALUES (114223575611, 30001, 1010101, CAST(N'2022-04-11' AS Date), N'no', 301201, 1, CAST(N'2022-01-04' AS Date), 50, N'VIP')
GO
INSERT [dbo].[Comment] ([HotelCode], [GuestID], [Comment]) VALUES (30001, 1010101, N'nice hotel, i will visit there once again')
INSERT [dbo].[Comment] ([HotelCode], [GuestID], [Comment]) VALUES (30001, 12323232, N'nice hotel, i will visit there once again')
GO
INSERT [dbo].[Contact] ([ID], [Name], [Email], [Content], [Status], [Feedbak]) VALUES (1, N'nguyen hong son', N'sondeptraicbg@gmail.com', N'i have to study Japanese next slot', 1, N'sondeptraicbg@gmail.com')
INSERT [dbo].[Contact] ([ID], [Name], [Email], [Content], [Status], [Feedbak]) VALUES (2, N'tran van chien', N'chien@gmail.com', N'My rich dad taught me about systems and how to be a leader of people, not a manager of people. Managers often see their subordinates as inferiors', 1, N'chien@gmail.com')
INSERT [dbo].[Contact] ([ID], [Name], [Email], [Content], [Status], [Feedbak]) VALUES (3, N'theresa may', N'may@gmail.com', N'A traditional way of learning about systems is getting your MBA from a prestigious school and then getting a fast-track job t', 1, N'An MBA is important because you learn the basics of accounting and how the financial numbers relate')
GO
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000001, 30001, N'Nguyen Hong', N'Son', N'Male', CAST(N'2002-06-29' AS Date), N'son@gmail.com', 5000, N'President', N'sondeptrai', 335633402, N'Execute everything', N'Working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000002, 30001, N'Nguyen Tran', N'Eminem', N'Male', CAST(N'1996-12-05' AS Date), N'eminem@gmail.com', 4000, N'Vice President', N'eminem', 38241021491, N'Support President', N'Out of working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000003, 30001, N'Barack', N'Obama', N'Male', CAST(N'1974-01-19' AS Date), N'obama@gmail.com', 2800, N'Staff', N'obama', 21044314812, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000004, 30001, N'Theresa', N'May', N'Female', CAST(N'1990-09-23' AS Date), N'theresamay@gmail.com', 4000, N'Staff', N'theresamay', 2934823432, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000005, 30001, N'Angela', N'Merkel', N'Male', CAST(N'2000-02-18' AS Date), N'angela@gmail.com', 4200, N'Human resource', N'angela', 1312454334, N'Recruitment', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000006, 30001, N'dmsow dowk', N'baner', N'Female', CAST(N'1992-07-08' AS Date), N'dowkbaner@gmail.com', 2900, N'Staff', N'dowkbaner', 12312434234, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000007, 30001, N'linder', N'oddy', N'Male', CAST(N'1995-04-20' AS Date), N'linderoddy@gmail.com', 3020, N'Manager room', N'oddy', 3243252425, N'Manage room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000008, 30001, N'tran nguyen', N'faker', N'Female', CAST(N'1998-12-06' AS Date), N'faker@gmail.com', 2850, N'Guarder', N'faker', 1231234324, N'Guard', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000009, 30002, N'James', N'Mary', N'Male', CAST(N'1990-08-19' AS Date), N'jamemary@gmail.com', 2230, N'President', N'jamemary', 21423552452, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000010, 30002, N'Robert', N'Patricia', N'Male', CAST(N'1998-01-15' AS Date), N'robert@gmail.com', 2103, N'Vice President', N'robert', 12312343252, N'Support President', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000011, 30002, N'John', N'Jennifer', N'Male', CAST(N'1999-08-16' AS Date), N'johnjen@gmail.com', 2013, N'Staff', N'johnjen', 12312435345, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000012, 30002, N'Michael', N'Linda', N'Female', CAST(N'1995-07-21' AS Date), N'michael@gmail.com', 2313, N'Staff', N'michael', 1234543653, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000013, 30002, N'David', N'Nuez', N'Male', CAST(N'2001-08-31' AS Date), N'davidnuez@gmail.com', 4214, N'Human resource', N'davidnuez', 6792304232, N'Recruitment', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000014, 30002, N'William', N'Lind', N'Female', CAST(N'1999-01-01' AS Date), N'william@gmail.com', 3545, N'Staff', N'william', 3276945685, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000015, 30002, N'Richard', N'Lison', N'Male', CAST(N'1999-04-22' AS Date), N'richard@gmail.com', 1233, N'Manager room', N'richard', 3265485695, N'Manage room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (3000016, 30002, N'Joseph', N'Miner', N'Female', CAST(N'2000-11-26' AS Date), N'joseph@gmail.com', 4353, N'Guarder', N'joseph', 32570329420, N'Guard', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (4300001, 43001, N'Thomas', N'Edison', N'Male', CAST(N'1991-09-10' AS Date), N'thomas@gmail.com', 3423, N'President', N'thomas', 2352352622, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (4300002, 43001, N'Charles', N'Addin', N'Male', CAST(N'1997-10-18' AS Date), N'charles@gmail.com', 1231, N'Vice President', N'charles', 436254252542, N'Support President', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (4300003, 43001, N'Christopher', N'Pold', N'Male', CAST(N'1998-01-10' AS Date), N'christo@gmail.com', 1434, N'Staff', N'christophe', 3465363636, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (4300004, 43001, N'Daniel', N'Holder', N'Female', CAST(N'1996-08-21' AS Date), N'daniel@gmail.com', 2414, N'Staff', N'daniel', 242352355, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (4300005, 43001, N'Matthew', N'Readd', N'Male', CAST(N'2000-08-30' AS Date), N'matthew@gmail.com', 1234, N'Human resource', N'matthew', 5475888888, N'Recruitment', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (4300006, 43001, N'Anthony', N'Milkk', N'Female', CAST(N'1998-02-02' AS Date), N'anthony@gmail.com', 3452, N'Staff', N'anthony', 242351111, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (4300007, 43001, N'Mark', N'Bride', N'Male', CAST(N'1997-04-29' AS Date), N'mark@gmail.com', 6575, N'Manager room', N'mark', 231242352, N'Manage room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (4300008, 43001, N'Donald', N'Trump', N'Female', CAST(N'2000-12-26' AS Date), N'donald@gmail.com', 1233, N'Guarder', N'donald', 231451151, N'Guard', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100001, 51001, N'Steven', N'Hawlking', N'Male', CAST(N'1995-09-10' AS Date), N'Steven@gmail.com', 3423, N'President', N'Steven', 2352352622, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100002, 51001, N'Paul', N'Pogba', N'Male', CAST(N'1998-10-18' AS Date), N'Paul@gmail.com', 1231, N'Vice President', N'Paul', 436254252542, N'Support President', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100003, 51001, N'Andrew', N'Noon', N'Male', CAST(N'1990-01-10' AS Date), N'Andrew@gmail.com', 1434, N'Staff', N'Andrew', 3465363636, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100004, 51001, N'Joshua', N'Loan', N'Female', CAST(N'1999-08-21' AS Date), N'Joshua@gmail.com', 2414, N'Staff', N'Joshua', 242352355, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100005, 51001, N'Kenneth', N'Jew', N'Male', CAST(N'2001-08-30' AS Date), N'Kenneth@gmail.com', 1234, N'Human resource', N'Kenneth', 5475888888, N'Recruitment', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100006, 51001, N'Kevin', N'Dbryun', N'Female', CAST(N'1990-02-02' AS Date), N'Kevin@gmail.com', 3452, N'Staff', N'Kevin', 242351111, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100007, 51001, N'Brian', N'Laa', N'Male', CAST(N'1991-04-29' AS Date), N'Brian@gmail.com', 6575, N'Manager room', N'Brian', 231242352, N'Manage room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100008, 51001, N'George', N'Goner', N'Female', CAST(N'2001-12-26' AS Date), N'George@gmail.com', 1233, N'Guarder', N'George', 231451151, N'Guard', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100009, 51002, N'Timothy', N'Bonn', N'Male', CAST(N'1995-09-10' AS Date), N'Timothy@gmail.com', 3423, N'President', N'Timothy', 2352352622, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100010, 51002, N'Ronald', N'Lome', N'Male', CAST(N'1998-10-18' AS Date), N'Ronald@gmail.com', 1231, N'Vice President', N'Ronald', 436254252542, N'Support President', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100011, 51002, N'Edward', N'Gaming', N'Male', CAST(N'1990-01-10' AS Date), N'Edward@gmail.com', 1434, N'Staff', N'Edward', 3465363636, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100012, 51002, N'Jason', N'Parl', N'Female', CAST(N'1999-08-21' AS Date), N'Jason@gmail.com', 2414, N'Staff', N'Jason', 242352355, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100013, 51002, N'Jeffrey', N'Ert', N'Male', CAST(N'2001-08-30' AS Date), N'Jeffrey@gmail.com', 1234, N'Human resource', N'Jeffrey', 5475888888, N'Recruitment', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100014, 51002, N'Ryan', N'Jung', N'Female', CAST(N'1990-02-02' AS Date), N'Ryan@gmail.com', 3452, N'Staff', N'Ryan', 242351111, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100015, 51002, N'Jacob', N'Bot', N'Male', CAST(N'1991-04-29' AS Date), N'Jacob@gmail.com', 6575, N'Manager room', N'Jacob', 231242352, N'Manage room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (5100016, 51002, N'Gary', N'Top', N'Female', CAST(N'2001-12-26' AS Date), N'Gary@gmail.com', 1233, N'Guarder', N'Gary', 231451151, N'Guard', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (7900001, 79001, N'Raymond', N'Nathan', N'Male', CAST(N'2000-02-29' AS Date), N'Raymond@gmail.com', 2141, N'President', N'Raymond', 1124234144, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (7900002, 79001, N'Jack', N'Henry', N'Male', CAST(N'1998-10-15' AS Date), N'Jack@gmail.com', 4243, N'Vice President', N'Jack', 123123111, N'Support President', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (7900003, 79001, N'Dennis', N'Douglas', N'Male', CAST(N'1996-11-19' AS Date), N'Dennis@gmail.com', 1231, N'Staff', N'Dennis', 414121241, N'Execute everything', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (7900004, 79001, N'Jerry', N'Zachary', N'Female', CAST(N'1991-08-23' AS Date), N'Jerry@gmail.com', 4141, N'Staff', N'Jerry', 241512311, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (7900005, 79001, N'Tyler', N'Peter', N'Male', CAST(N'2000-04-28' AS Date), N'Tyler@gmail.com', 4343, N'Human resource', N'Tyler', 1231412414, N'Recruitment', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (7900006, 79001, N'Aaron', N'Kyle', N'Female', CAST(N'1993-08-08' AS Date), N'Aaron@gmail.com', 2131, N'Staff', N'Aaron', 1231241424, N'Clean room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (7900007, 79001, N'Jose', N'Ethan', N'Male', CAST(N'1996-05-21' AS Date), N'Jose@gmail.com', 3422, N'Manager room', N'Jose', 352525626, N'Manage room', N'working')
INSERT [dbo].[Employees] ([EmoloyeeID], [HotelCode], [FirstName], [LastName], [Gender], [DateOfBirth], [Email], [Salary], [Role], [Password], [Phone], [RoleDesc], [Status]) VALUES (7900008, 79001, N'Adam', N'Walter', N'Female', CAST(N'1997-11-16' AS Date), N'Adam@gmail.com', 1231, N'Guarder', N'Adam', 4637357533, N'Guard', N'working')
GO
INSERT [dbo].[Guest] ([GuestID], [FirstName], [LastName], [DateOfBirth], [Phone], [Gender], [Email], [Password], [Address]) VALUES (1010101, N'ngueyn', N'son', CAST(N'2002-06-29' AS Date), 1010101, N'male', N'wwwsond@gmail.com', N'sozzz', N'bac giang')
INSERT [dbo].[Guest] ([GuestID], [FirstName], [LastName], [DateOfBirth], [Phone], [Gender], [Email], [Password], [Address]) VALUES (12323232, N'son1', N'sidasind', CAST(N'2022-09-28' AS Date), 12323232, N'on', N'asd@gmail.com', N'wwwww', N'bac giang')
INSERT [dbo].[Guest] ([GuestID], [FirstName], [LastName], [DateOfBirth], [Phone], [Gender], [Email], [Password], [Address]) VALUES (2312313113, N'dane', N'niel', CAST(N'2022-10-10' AS Date), 2312313113, N'on', N'abc@gmail.com', N'wewewewe', N'ha noi')
GO
INSERT [dbo].[Hotel] ([HotelCode], [HotelName], [Location], [NumRooms], [City], [Phone], [StarRating], [Img], [Map]) VALUES (30001, N'Marriot Ha Noi 1', N'01 Tran Duy Hung Street', 200, N'Ha Noi', 241454564, 4.9, N'imgs/hotel1.jpg', N'https://www.google.com/maps/embed/v1/place?q=JW+Marriott+Hotel+Hanoi,+Đỗ+Đức+Dục,+Mễ+Trì,+Từ+Liêm,+Hà+Nội,+Việt+Nam&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8')
INSERT [dbo].[Hotel] ([HotelCode], [HotelName], [Location], [NumRooms], [City], [Phone], [StarRating], [Img], [Map]) VALUES (30002, N'Marriot Ha Noi 2', N'241 Tran Dai Nghia Street', 120, N'Ha Noi', 241742510, 4.7, N'imgs/hotel2.jpg', N'https://www.google.com/maps/embed/v1/place?q=Hà+Nội,+Hoàn+Kiếm,+Hà+Nội,+Việt+Nam&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8')
INSERT [dbo].[Hotel] ([HotelCode], [HotelName], [Location], [NumRooms], [City], [Phone], [StarRating], [Img], [Map]) VALUES (43001, N'Marriot Da Nang 3', N'14 Khuat Duy Tien Street', 210, N'Da Nang', 241482374, 4.8, N'imgs/hotel3.jpg', N'https://www.google.com/maps/embed/v1/place?q=Đà+Nẵng+190,+Đường+Đà+Nẵng,+Lạc+Viên,+Ngô+Quyền,+Hải+Phòng,+Việt+Nam&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8')
INSERT [dbo].[Hotel] ([HotelCode], [HotelName], [Location], [NumRooms], [City], [Phone], [StarRating], [Img], [Map]) VALUES (51001, N'Marriot HCMC 5', N'410 Hai Ba Trung Street', 104, N'Ho Chi Minh', 241359437, 4.8, N'imgs/hotel4.jpg', N'https://www.google.com/maps/embed/v1/place?q=Khách+sạn+Mường+Thanh+Luxury+Sài+Gòn,+Nguyễn+Văn+Trỗi,+Phường+10+(Phú+Nhuận),+Phú+Nhuận,+Thành+phố+Hồ+Chí+Minh,+Việt+Nam&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8')
INSERT [dbo].[Hotel] ([HotelCode], [HotelName], [Location], [NumRooms], [City], [Phone], [StarRating], [Img], [Map]) VALUES (51002, N'Marriot HCMC 6', N'56 Ba Trieu Street', 152, N'Ho Chi Minh', 241438438, 4.5, N'imgs/hotel5.jpg', N'https://www.google.com/maps/embed/v1/place?q=khach+san,+Tô+Ký,+Trung+Mỹ+Tây,+Quận+12,+Thành+phố+Hồ+Chí+Minh,+Việt+Nam&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8')
INSERT [dbo].[Hotel] ([HotelCode], [HotelName], [Location], [NumRooms], [City], [Phone], [StarRating], [Img], [Map]) VALUES (79001, N'Marriot Nha Trang 68', N'122 Fidel Castro Street', 198, N'Nha Trang', 241832763, 4.6, N'imgs/hotel1.jpg', N'https://www.google.com/maps/embed/v1/place?q=Khách+Sạn+Nha+Trang+New+Century,+Nguyễn+Thị+Minh+Khai,+Tân+Lập,+Nha+Trang,+Khánh+Hòa,+Việt+Nam&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8')
GO
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (301101, N'VIP', 30001, 60, N'imgs/301101.jpg', N'First floor, easy to use services. It has proview to the HK lake', 28, N'twin bed or kingside', N'city', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (301201, N'Double Room', 30001, 50, N'imgs/301201.jpg', N'Second floor, Near to sauna room. Quite small room', 30, N'queenside bed', N'lake', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (301301, N'Standard room', 30001, 76, N'imgs/301301.jpg', N'Third floor, Next to GYM. Kingside bed', 28, N'twin bed or kingside', N'city', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (301401, N'VIP', 30001, 80, N'imgs/301401.jpg', N'Fourth floor, Next to bar. Many services there', 30, N'queenside bed', N'lake', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (301501, N'Deluxe room', 30001, 90, N'imgs/301501.jpg', N'Fifth floor, Next to Cafe. It has proview to the HK lake', 27, N'kingside bed', N'city', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (301601, N'Suite', 30001, 96, N'imgs/301601.jpg', N'Sixth floor, Sky restaurant. Can observe whole the city', 30, N'queenside bed', N'lake', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (302101, N'Standard Room', 30002, 60, N'imgs/302101.jpg', N'First floor, easy to use services. 2 or 3 persons(1 child)', 28, N'twin bed or kingside', N'city', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (302201, N'Standard', 30002, 60, N'imgs/302201.jpg', N'Second floor, Near to Cafe. Twin Beds', 28, N'twin bed or kingside', N'city', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (302301, N'Suite', 30002, 90, N'imgs/302301.jpg', N'Third floor, Sauna, Cafe. Proview to lake and mountain', 27, N'kingside bed', N'city', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (302401, N'VIP', 30002, 80, N'imgs/302401.jpg', N'Fourth floor, Next to GYM. Queenside Bed and many services', 30, N'queenside bed', N'lake', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (302501, N'Deluxe Room', 30002, 89, N'imgs/302501.jpg', N'Fifth floor, Restaurant, Bar. It has proview to the lake', 30, N'queenside bed', N'lake', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (302601, N'Suite', 30002, 96, N'imgs/302601.jpg', N'Sixth floor, Sky restaurant, Cafe, Bar. Special Services, Proview', 30, N'queenside bed', N'lake', 5)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (431101, N'Standard Room', 43001, 60, N'imgs/301101.jpg', N'First floor, easy to use services. 2 or 3 persons(1 child)', 28, N'twin bed or kingside', N'city', 6)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (431201, N'Standard', 43001, 60, N'imgs/301201.jpg', N'Second floor, Near to Cafe. Twin Beds', 40, N'queenside bed', N'city', 8)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (431301, N'Suite', 43001, 90, N'imgs/301301.jpg', N'Third floor, Sauna, Cafe. Proview to lake and mountain', 50, N'twin bed or kingside', N'lake', 2)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (431401, N'VIP', 43001, 80, N'imgs/301401.jpg', N'Fourth floor, Next to GYM. Queenside Bed and many services', 32, N'queenside bed', N'city', 6)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (431501, N'Deluxe Room', 43001, 89, N'imgs/301501.jpg', N'Fifth floor, Restaurant, Bar. It has proview to the lake', 38, N'kingside bed', N'lake', 7)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (431601, N'Suite', 43001, 96, N'imgs/301601.jpg', N'Sixth floor, Sky restaurant, Cafe, Bar. Special Services, Proview', 32, N'queenside bed', N'city', 6)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (511101, N'Standard Room', 51001, 60, N'imgs/301101.jpg', N'First floor, easy to use services. 2 or 3 persons(1 child)', 28, N'twin bed or kingside', N'city', 6)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (511102, N'Standard', 51001, 60, N'imgs/301201.jpg', N'Second floor, Near to Cafe. Twin Beds', 40, N'queenside bed', N'city', 8)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (511103, N'Suite', 51001, 90, N'imgs/301301.jpg', N'Third floor, Sauna, Cafe. Proview to lake and mountain', 50, N'twin bed or kingside', N'lake', 2)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (511104, N'VIP', 51001, 80, N'imgs/301401.jpg', N'Fourth floor, Next to GYM. Queenside Bed and many services', 32, N'queenside bed', N'city', 6)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (511105, N'Deluxe Room', 51001, 89, N'imgs/301501.jpg', N'Fifth floor, Restaurant, Bar. It has proview to the lake', 38, N'kingside bed', N'lake', 7)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (511106, N'Suite', 51001, 96, N'imgs/301601.jpg', N'Sixth floor, Sky restaurant, Cafe, Bar. Special Services, Proview', 32, N'queenside bed', N'city', 6)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (791101, N'Standard Room', 79001, 60, N'imgs/301101.jpg', N'First floor, easy to use services. 2 or 3 persons(1 child)', 28, N'twin bed or kingside', N'city', 6)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (791102, N'Standard', 79001, 60, N'imgs/301201.jpg', N'Second floor, Near to Cafe. Twin Beds', 40, N'queenside bed', N'city', 8)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (791103, N'Suite', 79001, 90, N'imgs/301301.jpg', N'Third floor, Sauna, Cafe. Proview to lake and mountain', 50, N'twin bed or kingside', N'lake', 2)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (791104, N'VIP', 79001, 80, N'imgs/301401.jpg', N'Fourth floor, Next to GYM. Queenside Bed and many services', 32, N'queenside bed', N'city', 6)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (791105, N'Deluxe Room', 79001, 89, N'imgs/301501.jpg', N'Fifth floor, Restaurant, Bar. It has proview to the lake', 38, N'kingside bed', N'lake', 7)
INSERT [dbo].[Room] ([RoomID], [RoomType], [HotelCode], [RoomPrice], [RoomImg], [RoomDesc], [Area], [Bed], [Direct], [Available]) VALUES (791106, N'Suite', 79001, 96, N'imgs/301601.jpg', N'Sixth floor, Sky restaurant, Cafe, Bar. Special Services, Proview', 32, N'queenside bed', N'city', 6)
GO
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (30001, 30001, N'Front Desk', 4.7, N'imgs/ser30001.jpg', N'The front desk person will need to receive and handle tasks related to: welcoming customers and completing check out procedures when they leave. In addition, this department also needs to solve customer problems during their stay such as: information about rooms and other convenient services of the hotel, feedback on staff attitudes or quality of facilities')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (30002, 30001, N'Hot tub', 4.8, N'imgs/ser30002.jpg', N'Soaking in hot water is considered an effective method to help relax the body after a long day of work and study. In addition, spending time soaking in hot water also brings many other health benefits such as reducing pain from arthritis, fibromyalgia and low back pain.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (30003, 30001, N'Tennis court', 4.5, N'imgs/ser30003.jpg', N'Carpet courts are often used when people borrow basketball courts or other indoor sports courts to compete in tennis tournaments. The organizers spread a special carpet made for tennis on the court and set up poles and nets. Carpet courts usually have a medium bounce, so they are suitable for all types of ball games.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (30004, 30001, N'Airport shuttle', 4.7, N'imgs/ser30004.jpg', N'With a wide range of options from private cars to airport buses, its easy to find the best transport option for you. Your comfort is our priority. Therefore, we always choose to work with the most experienced partners in the market')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (30005, 30002, N'Front Desk', 4.7, N'imgs/ser30001.jpg', N'The front desk person will need to receive and handle tasks related to: welcoming customers and completing check out procedures when they leave. In addition, this department also needs to solve customer problems during their stay such as: information about rooms and other convenient services of the hotel, feedback on staff attitudes or quality of facilities')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (30006, 30002, N'Hot tub', 4.8, N'imgs/ser30002.jpg', N'Soaking in hot water is considered an effective method to help relax the body after a long day of work and study. In addition, spending time soaking in hot water also brings many other health benefits such as reducing pain from arthritis, fibromyalgia and low back pain.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (30007, 30002, N'Tennis court', 4.5, N'imgs/ser30003.jpg', N'Carpet courts are often used when people borrow basketball courts or other indoor sports courts to compete in tennis tournaments. The organizers spread a special carpet made for tennis on the court and set up poles and nets. Carpet courts usually have a medium bounce, so they are suitable for all types of ball games.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (30008, 30002, N'Airport shuttle', 4.7, N'imgs/ser30004.jpg', N'With a wide range of options from private cars to airport buses, its easy to find the best transport option for you. Your comfort is our priority. Therefore, we always choose to work with the most experienced partners in the market')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (43001, 43001, N'Front Desk', 4.7, N'imgs/ser30001.jpg', N'The front desk person will need to receive and handle tasks related to: welcoming customers and completing check out procedures when they leave. In addition, this department also needs to solve customer problems during their stay such as: information about rooms and other convenient services of the hotel, feedback on staff attitudes or quality of facilities')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (43002, 43001, N'Hot tub', 4.8, N'imgs/ser30002.jpg', N'Soaking in hot water is considered an effective method to help relax the body after a long day of work and study. In addition, spending time soaking in hot water also brings many other health benefits such as reducing pain from arthritis, fibromyalgia and low back pain.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (43003, 43001, N'Tennis court', 4.5, N'imgs/ser30003.jpg', N'Carpet courts are often used when people borrow basketball courts or other indoor sports courts to compete in tennis tournaments. The organizers spread a special carpet made for tennis on the court and set up poles and nets. Carpet courts usually have a medium bounce, so they are suitable for all types of ball games.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (43004, 43001, N'Airport shuttle', 4.7, N'imgs/ser30004.jpg', N'With a wide range of options from private cars to airport buses, its easy to find the best transport option for you. Your comfort is our priority. Therefore, we always choose to work with the most experienced partners in the market')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (51001, 51001, N'Front Desk', 4.7, N'imgs/ser30001.jpg', N'The front desk person will need to receive and handle tasks related to: welcoming customers and completing check out procedures when they leave. In addition, this department also needs to solve customer problems during their stay such as: information about rooms and other convenient services of the hotel, feedback on staff attitudes or quality of facilities')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (51002, 51001, N'Hot tub', 4.8, N'imgs/ser30002.jpg', N'Soaking in hot water is considered an effective method to help relax the body after a long day of work and study. In addition, spending time soaking in hot water also brings many other health benefits such as reducing pain from arthritis, fibromyalgia and low back pain.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (51003, 51001, N'Tennis court', 4.5, N'imgs/ser30003.jpg', N'Carpet courts are often used when people borrow basketball courts or other indoor sports courts to compete in tennis tournaments. The organizers spread a special carpet made for tennis on the court and set up poles and nets. Carpet courts usually have a medium bounce, so they are suitable for all types of ball games.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (51004, 51001, N'Airport shuttle', 4.7, N'imgs/ser30004.jpg', N'With a wide range of options from private cars to airport buses, its easy to find the best transport option for you. Your comfort is our priority. Therefore, we always choose to work with the most experienced partners in the market')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (51005, 51002, N'Hot tub', 4.8, N'imgs/ser30002.jpg', N'Soaking in hot water is considered an effective method to help relax the body after a long day of work and study. In addition, spending time soaking in hot water also brings many other health benefits such as reducing pain from arthritis, fibromyalgia and low back pain.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (51006, 51002, N'Tennis court', 4.5, N'imgs/ser30003.jpg', N'Carpet courts are often used when people borrow basketball courts or other indoor sports courts to compete in tennis tournaments. The organizers spread a special carpet made for tennis on the court and set up poles and nets. Carpet courts usually have a medium bounce, so they are suitable for all types of ball games.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (51007, 51002, N'Airport shuttle', 4.7, N'imgs/ser30004.jpg', N'With a wide range of options from private cars to airport buses, its easy to find the best transport option for you. Your comfort is our priority. Therefore, we always choose to work with the most experienced partners in the market')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (51008, 51002, N'Front Desk', 4.7, N'imgs/ser30001.jpg', N'The front desk person will need to receive and handle tasks related to: welcoming customers and completing check out procedures when they leave. In addition, this department also needs to solve customer problems during their stay such as: information about rooms and other convenient services of the hotel, feedback on staff attitudes or quality of facilities')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (79001, 79001, N'Front Desk', 4.7, N'imgs/ser30001.jpg', N'The front desk person will need to receive and handle tasks related to: welcoming customers and completing check out procedures when they leave. In addition, this department also needs to solve customer problems during their stay such as: information about rooms and other convenient services of the hotel, feedback on staff attitudes or quality of facilities')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (79002, 79001, N'Hot tub', 4.8, N'imgs/ser30002.jpg', N'Soaking in hot water is considered an effective method to help relax the body after a long day of work and study. In addition, spending time soaking in hot water also brings many other health benefits such as reducing pain from arthritis, fibromyalgia and low back pain.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (79003, 79001, N'Tennis court', 4.5, N'imgs/ser30003.jpg', N'Carpet courts are often used when people borrow basketball courts or other indoor sports courts to compete in tennis tournaments. The organizers spread a special carpet made for tennis on the court and set up poles and nets. Carpet courts usually have a medium bounce, so they are suitable for all types of ball games.')
INSERT [dbo].[Service] ([ServiceCode], [HotelCode], [ServiceName], [StarRating], [ServiceImg], [ServiceDes]) VALUES (79004, 79001, N'Airport shuttle', 4.7, N'imgs/ser30004.jpg', N'With a wide range of options from private cars to airport buses, its easy to find the best transport option for you. Your comfort is our priority. Therefore, we always choose to work with the most experienced partners in the market')
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD FOREIGN KEY([GuestID])
REFERENCES [dbo].[Guest] ([GuestID])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([GuestID])
REFERENCES [dbo].[Guest] ([GuestID])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([HotelCode])
REFERENCES [dbo].[Hotel] ([HotelCode])
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD FOREIGN KEY([RoomID])
REFERENCES [dbo].[Room] ([RoomID])
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([GuestID])
REFERENCES [dbo].[Guest] ([GuestID])
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([HotelCode])
REFERENCES [dbo].[Hotel] ([HotelCode])
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD FOREIGN KEY([HotelCode])
REFERENCES [dbo].[Hotel] ([HotelCode])
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD FOREIGN KEY([HotelCode])
REFERENCES [dbo].[Hotel] ([HotelCode])
GO
ALTER TABLE [dbo].[Service]  WITH CHECK ADD FOREIGN KEY([HotelCode])
REFERENCES [dbo].[Hotel] ([HotelCode])
GO
ALTER TABLE [dbo].[Guest]  WITH CHECK ADD  CONSTRAINT [CK__Guest__Email__3E52440B] CHECK  (([Email] like '%_@__%.__%'))
GO
ALTER TABLE [dbo].[Guest] CHECK CONSTRAINT [CK__Guest__Email__3E52440B]
GO
