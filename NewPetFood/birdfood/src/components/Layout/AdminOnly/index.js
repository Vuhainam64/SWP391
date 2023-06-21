import AdminHeader from '~/components/Layout/components/AdminHeader';

function AdminLayout({ children }) {
    return (
        <div>
            <AdminHeader />
            <div className="container">
                <div className="content">{children}</div>
            </div>
        </div>
    );
}

export default AdminLayout;
